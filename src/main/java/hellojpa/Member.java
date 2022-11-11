package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //jpa 가 관리한다
public class Member {

    @Id //PK
    private Long id;

    @Column(name = "name", nullable = false) //DB에 이름을 "name"으로 한다. nullable = false : not null 제약 조건
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)//DB에는 Enum 타입이 없기 때문에 String으로 돌려준다.
    //@Enumerated : EnumType.ORDINAL이 기본 값이며 숫자들어가서 안된다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 날짜 맵핑
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob //큰 컨텐츠를 넣어주고 싶을때
    private String decription;

    @Transient // DB에 넣지 않고 메모리에서 쓰겠다.
    private int temp;

    public Member() {} // 기본생성자는 있어야 한다.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
