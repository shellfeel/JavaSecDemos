package shiro;

import beans.User;
import expUtils.PayloadUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.mgt.AbstractRememberMeManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.CookieRememberMeManager;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Decrypt {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {

        User user = new User();
        user.setAge(18);
        user.setName("xxfB");

//        PayloadUtils.getCommonBeanExp()
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(user);
        byte[] payload = byteArrayOutputStream.toByteArray();

        AbstractRememberMeManager abstractRememberMeManager = new CookieRememberMeManager();


//        String cipher = "VPvGfrsiVYaOdcxcpsmFI0bY2g7ehAcyXJRAfG2Ihaz1o2gr2OupJHZxMmRDg89WHiz54GLrkjOZU+9zwQiL3TtqPYtmh0TyQjsRJTbWj93m31G+/aLPu/l1Rj24ZhcHQTliotQdOnRvrZODb1XScxxEfBmtNc6/9E8CGXGJZALDzysLMoBWnIpcHA/5gXoZ3wlG6zL8WeBAh/TFe67zhIQefVe+7khm/klbHMbPrHQjPLZpioXVsSUfPkSLk+duwKGrt6th9Km9Z1roAE7j0l6BMXm4Sd8mYJquixcWM5Vu+diXxYReoOwLLV/E3cZsalFGI/EUtxDe+CHhJRLL41TKhuaE5cSNRIBoBS09Q2/cw2xMNCZfcj9RIryNcNITzZnRJQ/9/T3fhfw8ozzGs8XX82i9GV4kf5XVzTyrWFW6rWOC6QoC5SsCjvvonYuplBxb/D75SJJ9Cx8shEyZ0WAvjf8tTubByuG3XE5NCMFQ2XNROcIj5k/Ts2j0pbeA";
//        AesCipherService aesCipherService = new AesCipherService();
//        String key = "kPH+bIxk5D2deZiIxcaaaA==";
//        ByteSource plain_text = aesCipherService.decrypt(Base64.decode(cipher),Base64.decode(key));
//        System.out.println(Base64.encodeToString(plain_text.getBytes()));

        Object obj = abstractRememberMeManager.getSerializer().deserialize(payload);
        SimplePrincipalCollection set = (SimplePrincipalCollection) obj;
        String a="1";
        System.out.println(obj);
    }
}
