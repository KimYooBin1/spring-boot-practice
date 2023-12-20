package hello.springhello.service;

import hello.springhello.repository.MemberRepository;
import hello.springhello.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//spring bean 을 auto donfiguration 하지 않고 직접 생성하는 방식


@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
