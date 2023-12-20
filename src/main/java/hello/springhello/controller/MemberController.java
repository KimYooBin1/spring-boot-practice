package hello.springhello.controller;

import hello.springhello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

//    @Autowired      //setter 주입 : setter 가 나중에 호출되서 객체가 들어온다(setter 가 public 으로 열려있어야되기때문에 문제발생)
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }
//    @Autowired private MemberService memberService;     //DI 필드 주입 : 별로 좋지않다. 변경이 힘들다



    @Autowired      //controller 는 프로그램 시작시 spring 이 객체 하나를 만들어둔다. autowired 를 통해서 해당 객체를 연결해준다(생성자 주입, 권장하는 방식)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
