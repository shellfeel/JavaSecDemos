import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

public class JavaAssitDemo {

    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass =  pool.get("MainTest");
        System.out.println(ctClass.toBytecode());
    }
}
