package Test_CC;

import java.util.HashMap;

public class Test7_3 {

    public static int testHashCode(String str){
       return 1;
    }

    public static void main(String[] args) {
        HashMap hashMap1 = new HashMap();
        HashMap hashMap2 = new HashMap();

        hashMap1.put("aa",1);
        hashMap2.put("bB",1);

        System.out.println(hashMap1.hashCode());
        System.out.println(hashMap2.hashCode());
        System.out.println("aa".hashCode());
        System.out.println("bB".hashCode());
        System.out.println("aa".equals("bB"));
    }
}
