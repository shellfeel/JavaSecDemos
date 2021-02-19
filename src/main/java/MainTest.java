import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

    static Logger log = LoggerFactory.getLogger(MainTest.class);
    public static void main(String[] args) {
        log.debug("--debug--");
        log.warn("--warn--");
        log.error("--error--");
        log.info("--info--");
        System.out.println("hello world !!!");

    }
}
