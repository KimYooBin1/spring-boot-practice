package hello.springhello.service;

import hello.springhello.aop.TimeTraceAop;
import hello.springhello.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//spring bean 을 auto donfiguration 하지 않고 직접 생성하는 방식


@Configuration
public class SpringConfig {

    //Jpbc template 설정
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    //JPA 사용시 설정
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }


}
