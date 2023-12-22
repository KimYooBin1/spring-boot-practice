package hello.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")    //static page  보다 높은 우선순위를 가진다.
    public String home(){
        return "home";
    }
}
