package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestMain {
    public static void main(String[] args) {
//        CatImpl cat = ;
        InvocationHandler handler = new AnimalHandler(new CatImpl());
        Animal cat = (Animal) Proxy.newProxyInstance(TestMain.class.getClassLoader(),CatImpl.class.getInterfaces(),handler);
        cat.eat();
    }
}
