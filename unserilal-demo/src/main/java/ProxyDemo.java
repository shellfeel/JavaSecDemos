import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {

    public void beforeExe(){
        System.out.println("执行前");
    }
    public void aferterExe(){
        System.out.println("执行后");
    }

    public static void main(String[] args) {
        final ProxyDemo proxyDemo = new ProxyDemo();


        PersonBean personProxyBean = (PersonBean) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{PersonBean.class}
                , new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        proxyDemo.beforeExe();
                        Object obj = method.invoke(proxy,args);
                        proxyDemo.aferterExe();
                        return obj;
                    }
                });



    }
}
