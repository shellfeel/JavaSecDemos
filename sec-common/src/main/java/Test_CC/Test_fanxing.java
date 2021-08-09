package Test_CC;

public class Test_fanxing {
    public static void main(String[] args) {

        System.out.println(max(1, 2));
        System.out.println(max(2.0, 3.0));

    }

    private static <T extends Comparable> T max(T t1, T t2) {
        return t1.compareTo(t2) > 0 ? t1 : t2;
    }
}
