package TestJdk;

import expUtils.ExpUtils;

import java.io.IOException;

public class Test7u21 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
    }
}
