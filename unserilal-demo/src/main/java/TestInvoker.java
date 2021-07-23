import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class TestInvoker implements InvocationHandler, Serializable {

    private Object obj0;
    private Map transformMap;

    public TestInvoker(Object obj, Map transformMap){
        this.obj0 = obj;
        this.transformMap =  transformMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("pre");
        Object result =  method.invoke(obj0,args);
        transformMap.get("123");
        System.out.println("after");
        return result;
    }
}
