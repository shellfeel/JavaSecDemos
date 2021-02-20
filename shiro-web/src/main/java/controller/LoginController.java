package controller;

import beans.LoginPassword;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Subject subject;

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String doLogin(LoginPassword loginPassword, HttpServletResponse httpServletResponse){
        boolean flag = false;
        AccessControlFilter
        subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()){
            System.out.println("已经登录过，直接跳转");
            flag = true;

        }else {
            UsernamePasswordToken usernamePasswordToken= new UsernamePasswordToken(loginPassword.getUsername(),loginPassword.getPassword(),true);
            try {
                subject.login(usernamePasswordToken);
                flag = true;
            } catch (AuthenticationException e) {
                System.out.println(e.getMessage());
            }

        }

        if (flag){
            System.out.println("登录成功");
            try {
                httpServletResponse.sendRedirect("../sec/no");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("登录失败");
            return "login failure~";
        }
        return "success";

    }
}
