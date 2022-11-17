package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //jpa 가 관리한다
//@SequenceGenerator(name = "member_seq_generator",
//sequenceName = "member_seq")
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {

    //기본 키 매핑 어노테이션 : @Id, @GeneratedValue
     //PK
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") //DB에 이름을 "name"으로 한다. nullable = false : not null 제약 조건
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team; //다대일
    
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID",insertable = false, updatable = false)
//    private Team team; 일대다 양방향 : insertable = false, updatable = false 으로 읽기 전용으로 맵핑

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

    /*public void setTeam(Team team) {
        this.team = team;
        //team.getMembers().add(this); //연관관계 편의 메소드
    }*/

    /* private Integer age;

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
    }*/
}
