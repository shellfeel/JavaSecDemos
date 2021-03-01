package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/sec")
public class SecController {

    @RequestMapping("/no")
    @ResponseBody
    public String no(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }
//        System.out.println();
        return "this page is security which is not everyone can see it!";
    }
}
