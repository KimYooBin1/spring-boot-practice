package hello.springhello.repository;

import hello.springhello.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //JPA 가 인터페이스에 대한 구현체를 스스로 만들어서 spring bean 에 등록한다. JPA 에는 이미 save, findALL 과 같은 공통 코드가 이미 작성되어있다
    @Override
    Optional<Member> findByName(String name);
    /**
     * 공통으로는 id 가 기본적으로 있고 name 이나 email 로 찾고 싶으면 원래는 코드를 작성해줘야됬다. 하지만 함수 이름에 정의되어 있는 규칙을 사용해서 jpa data 가 자동으로
     * 작성해준다 findByName = select m from Member m where m.name = ?
     */
}
