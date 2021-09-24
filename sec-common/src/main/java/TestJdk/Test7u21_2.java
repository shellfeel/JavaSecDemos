package TestJdk;

import expUtils.ExpUtils;

import java.io.IOException;

public class Test7u21_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExpUtils.unserialize("my_java.util.LinkedHashSet.ser");
    }
}
