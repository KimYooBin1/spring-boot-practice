package hello.springhello.repository;

import hello.springhello.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);     //Optional 이란? Member 에서 그냥 null을 출력할 수도 있지만 Optional 을 씌움으로 인해 다른 처리가 가능한다.
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
