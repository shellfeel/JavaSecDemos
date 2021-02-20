import ExpUtils.ExpUtils;
import ExpUtils.ReflectUtils;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import org.apache.commons.beanutils.BeanComparator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.PriorityQueue;


public class CommonBeanDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, ClassNotFoundException {

        ExpUtils.unserialize(ExpUtils.serialize(ExpUtils.getCommonBeanExp()));


    }
}
