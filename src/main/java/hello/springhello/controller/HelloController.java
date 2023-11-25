package hello.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")    //get post : hello 를 받는다
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";     //resource templates 에서 hello를 가진 파일을 실행한다
    }
}
