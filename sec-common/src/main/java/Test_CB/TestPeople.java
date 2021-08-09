package Test_CB;

import expUtils.ReflectUtils;
import org.apache.commons.beanutils.BeanComparator;

import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class TestPeople {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        People people1 = new People();
        people1.setAge(18);
        people1.setName("b1");

        People people2 = new People();
        people2.setAge(25);
        people2.setName("b2");

        BeanComparator beanComparator = new BeanComparator("Xx");
        PriorityQueue priorityQueue = new PriorityQueue(2,beanComparator);
        priorityQueue.add(people1);
        priorityQueue.add(people2);

    }
}
