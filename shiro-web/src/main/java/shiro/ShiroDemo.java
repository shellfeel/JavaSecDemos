package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

public class ShiroDemo {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(new CustomRealm());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("xxf","xxf123");
        subject.login(token);
    }
}
