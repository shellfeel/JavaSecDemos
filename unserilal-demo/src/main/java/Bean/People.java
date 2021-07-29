package Bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;

public class People implements Serializable {

    private String name;
    private int age;
    private Map memberValues;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    private Object obj;

    public Map getMemberValues() {
        return memberValues;
    }

    public void setMemberValues(Map memberValues) {
        this.memberValues = memberValues;
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

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        // Read in (and discard) array length
        ois.readInt();
        ois.readObject();
//     1   lazymap.get("1");

    }
}
