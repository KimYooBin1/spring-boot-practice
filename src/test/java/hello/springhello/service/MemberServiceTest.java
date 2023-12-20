package hello.springhello.service;

import hello.springhello.domain.Member;
import hello.springhello.repository.MemoryMemberRepository;
import hello.springhello.repository.MemoryMemberRepositoryTest;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {   //test 는 과감히 한글로 작성해도 좋다
        //given : 무엇이 주어졌을때
        Member member = new Member();
        member.setName("hello");
        //when : 언?제
        Long saveId = memberService.join(member);
        //then : 무엇이 나와야되는지
        Member findMember= memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        //2번째 매개변수의 로직을 실행해서 1번째 예외가 발생해야 된다
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        //좋지않은 방법
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//         }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}