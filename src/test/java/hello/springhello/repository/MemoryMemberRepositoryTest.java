package hello.springhello.repository;

import hello.springhello.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach      //메소드가 끝날때마다 어떤 동작을 함(주로 clear 를 한다)
    public void afterEach(){
        repository.clearStore();    //clear 를 해주게 되면 모든 test 가 정상작동을 하게 된다
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));     일일이 결과를 분석하기는 버겁다
//        Assertions.assertEquals(member, result);        //assertions 를 이용해 결과값 -> 기대값을 비교할 수 있다
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

//test 시에는 어떤 메소드가 먼저 실행될지 모른다. 따라서 각각이 따로 작동하도록 설계를 해야된다
//실제 여기에서는 findAll 이 먼저 실행되 spring1 이 이미 저장되었고 그 뒤에 findByName 이 실행되었기 때문에 findByName 에서 제대로된 test 가 진행되지 않는다
// 그렇게 때문에 각 test 가 끝나면 clear를 해줘야 된다