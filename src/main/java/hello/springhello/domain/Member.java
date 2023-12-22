package hello.springhello.domain;


import jakarta.persistence.*;

@Entity //jpa가 관리하는 entity 라고 인식한
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key 이고 id값을 db 가 알아서 생성해준다
    private Long id;
//    @Column(name = "username")  //table 의 이름을 username 으로 바꾼다

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
