import Bean.People;
import org.apache.commons.collections.functors.InstantiateTransformer;

import java.util.HashMap;

public class MainTrueTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        InstantiateTransformer instantiateTransformer = new InstantiateTransformer(new Class[]{}, new Object[]{});
//        instantiateTransformer.transform(PersonBean.class);
//        MainTrueTest.class.getClassLoader().loadClass("PersonBean");
        HashMap<String, Integer> stringHashMap = new HashMap<>();

        stringHashMap.put("test1",1);

        People personBean = new People();
        personBean.setAge(18);
        personBean.setName("xxf");
        personBean.setMemberValues(stringHashMap);
        System.out.println(personBean.getMemberValues());
        stringHashMap.put("test2",2);
        System.out.println(personBean.getMemberValues());



    }
}
