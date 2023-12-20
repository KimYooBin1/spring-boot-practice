package hello.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody       //http 통신에서의 body 부분에 직접 넣어준다.
    //기존에는 controller 를 통해 들어온 입력을 viewResolver 에게 전달해줬지만 @ResponseBody 가 붙게 되면 MessageConverter 에게 전달해줘서 String 처리를 해준다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;  //그대로 문자를 소스로 출력한다
    }

    @GetMapping("hello-api")    //실제 api 요청을 통해 출력되는 JSON 형식의 String
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("age") String age){
        //command + shift + enter => 세미콜론과 같은 문장 종료를 자동으로 해준다.(괄호닫기, 세미콜론 붙이기, etc..)
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
    }

    static class Hello{
        private String name;
        private String age;

        //command + N 또는 control + enter 를 통해 getter, setter 를 쉽게 생성할 수 있다

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
