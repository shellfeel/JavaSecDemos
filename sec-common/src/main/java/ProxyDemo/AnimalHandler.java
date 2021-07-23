package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalHandler implements InvocationHandler {

    private final Object obj0;

    public AnimalHandler(Object obj0){
        this.obj0 = obj0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre");
        Object res = method.invoke(obj0,args);
        System.out.println("after");
        return res;
    }
}
