package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.mgt.DefaultFilter;

public class ShiroDemo {
    public static void main(String[] args) {


//        System.out.printf(DefaultFilter.values());

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(new CustomRealm());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("xxf","xxf123");
        subject.login(token);
    }
}
