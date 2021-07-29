import expUtils.ExpUtils;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.map.LazyMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class CC7Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(System.getProperty("java.version"));
        ExpUtils.unserialize("cc7.bin");
//        ChainedTransformer
//        HashMap

    }
}
