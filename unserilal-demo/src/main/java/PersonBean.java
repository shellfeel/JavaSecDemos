public class PersonBean {

    public int testVal = 0;

    static {

        System.out.println("test");
    }


    public PersonBean(){

        System.out.println("我被初始化了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;
}
