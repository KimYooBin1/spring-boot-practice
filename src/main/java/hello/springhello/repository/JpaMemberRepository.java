package hello.springhello.repository;

import hello.springhello.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private  final EntityManager em; //JPA 는 entity manager 로 모든게 동작한다

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save (Member member) {
        em.persist(member); //jpa는 query 문 추가 작성없이 spring boot 가 자동으로 작성해준다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);  //조회할 타입이랑 식별자 pk 를 입력
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {     //findall 에서는 pk 를 사용할수없기 때문에 jpql query 언어를 사용해야된다. 객체를 대상으로 query 를 날린다
        return em.createQuery("select m from Member m", Member.class).getResultList(); //기존에는 m.id , m.name 과 같은 query 문을 사용해야됬지만 여기서는 객체를 지정할 수 있다.
    }
}
