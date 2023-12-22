package hello.springhello.controller;

import hello.springhello.domain.Member;
import hello.springhello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
