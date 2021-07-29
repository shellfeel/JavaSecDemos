import Bean.Evil;
import Bean.People;
import expUtils.ExpUtils;
import expUtils.OuterObj;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class SerialDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        ExpUtils.getEvilLazyMap().entrySet();
        Map goodMap = new HashMap();
        goodMap.put("test","123");

        System.out.println(System.getProperty("java.version"));

//        InvocationHandler invocationHandler =  new TestInvoker(goodMap,null);
//        Map proxyMap = (Map) Proxy.newProxyInstance(SerialDemo.class.getClassLoader(),goodMap.getClass().getInterfaces(),invocationHandler);

        People people = new People();
        people.setAge(18);
        people.setName("xxf");
        people.setMemberValues(goodMap);
        people.setObj(new OuterObj());
        String path = ExpUtils.serialize(people);
        System.out.println("unseriallllll");
        People people1 = (People) ExpUtils.unserialize(path);
        people1.setName("xxf2");
        System.out.println(people1.getName());
//        System.out.println(people1.getName());
    }
}
