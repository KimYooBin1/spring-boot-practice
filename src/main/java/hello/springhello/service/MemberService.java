package hello.springhello.service;

import hello.springhello.domain.Member;
import hello.springhello.repository.MemberRepository;
import hello.springhello.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {   //dependancy injection(의존 관계 주입 = DI)
        this.memberRepository = memberRepository;
    }

    /*
    * 회원 가입
    */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { //Optional 을 사용해서 null 처리를 따로 하지 않아도 된다
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        //코드를 깔끔하게 작성할 수 있다
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    /*
    * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
