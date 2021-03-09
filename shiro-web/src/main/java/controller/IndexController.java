package controller;

//import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController{
   @RequestMapping(value = "/index")
    public String index(HttpSession session, HttpServletRequest httpServletRequest){
       System.out.println("request");
       Cookie[] cookies = httpServletRequest.getCookies();
       for (Cookie cookie: cookies){
           System.out.println(cookie.getName() + ": " + cookie.getValue());
       }
       session.setAttribute("skey","xxf");
       return "index";
   }
   @RequestMapping(value = "/test")
   @ResponseBody
    public String test(HttpSession session){

       return (String) session.getAttribute("skey");
   }

//   @RequestMapping(value = "/json", method = RequestMethod.POST, consumes = "application/json")
//   @ResponseBody
//   public String json(@RequestBody User user){
//       return user.toString();
//   }
}
