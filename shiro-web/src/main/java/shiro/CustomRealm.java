package shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

public class CustomRealm extends AuthorizingRealm {

    private HashMap<String,String> userNamePassword = new HashMap<String,String>() ;

    public CustomRealm(){
        userNamePassword.put("xxf","xxf123");
    }

    private String getPasswordByUsername(String username){
        return userNamePassword.get(username);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 获取用户名
        // 2. 根据用户名获取密码
        // 3. 返回SimpleAuthenticationInfo 对象，把正确的用户名和密码交给SimpleAuthenticationInfo
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = (String) token.getPrincipal();
        String password =  getPasswordByUsername(username);
        if (password != null){
            return new SimpleAuthenticationInfo(username,password,"XxfRealmName");
        }else {
            return null;
        }

    }
}
