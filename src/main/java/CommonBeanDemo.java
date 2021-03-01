import expUtils.ExpUtils;

import java.io.IOException;


public class CommonBeanDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, ClassNotFoundException {

        ExpUtils.unserialize(ExpUtils.serialize(ExpUtils.getCommonBeanExp()));


    }
}
