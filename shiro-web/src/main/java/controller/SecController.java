package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sec")
public class SecController {

    @RequestMapping("/no")
    @ResponseBody
    public String no(){
        return "this page is security which is not everyone can see it!";
    }
}
