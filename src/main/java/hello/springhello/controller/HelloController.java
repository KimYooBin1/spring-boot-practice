package hello.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")    //get post : /hello 을 인식한다
    public String hello(Model model){
        model.addAttribute("data", "hello!!");  //key는 data, value 는 hello!!
        return "hello";     //resource templates 에서 hello를 가진 파일을 실행시켜라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

}
