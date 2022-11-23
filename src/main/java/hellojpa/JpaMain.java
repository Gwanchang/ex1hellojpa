package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;

public class JpaMain {

    public static void main(String[] args) {
        //로딩 시점에 딱 하나(DB당)만 만들어야한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); //모든 변경은 Transaction 통해서 한다.
        tx.begin();

        try {
            /*
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
            //비영속
            Member member1 = new Member();
            member1.setId(101L);
            member1.setName("HelloJPA");

            //영속 상태 : DB저장 X, 엔티티매니저 안에 영속성 컨텍스트에서 관리한다.
            System.out.println("=== BEFORE ===");
            em.persist(member1); // 1차 캐시에 저장
            //em.detach(member1); // 영속상태에서 지움
            System.out.println("=== AFTER ===");

            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8) //1 ~ 5 가져와(페이징)
                    .getResultList();
            // 대상이 테이블이 아닌 객체(엔티티)
            for (Member member1 : result) {
                System.out.println("member1.name = " + member1.getName());
            }
            */

            /*
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember2 == findMember1));
            */

            /*
            //영속
            Member member1 = em.find(Member.class, 150L);
            member1.setName("ZZZZ");
            */

            /*
            Member member1 = new Member(200L, "member200");
            em.persist(member1);

            em.flush(); // commit 되기 전에 쿼리를 날린다.
            */

            /*
            //영속
            Member member1 = em.find(Member.class, 150L);
            member1.setName("AAAAA");

            em.detach(member1); // 준영속 상태 : 영속성 컨텍스트에서 더 이상 관리하지 않는다.
            */

            /*//저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);*/

            /*Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team); //연관관계의 주인에 값 설정
            em.persist(member1);*/

            //team.getMembers().add(member1);

            /*Member member1 = new Member();
            member1.setUsername("member1");

            em.persist(member1);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member1);

            em.persist(team);*/

            //Team findTeam = em.find(Team.class, team.getId()); //1차 캐시


//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);

//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            System.out.println("m1 == m2 :  " + (m1 instanceof Member));
//            System.out.println("m1 == m2 :  " + (m2 instanceof Member));

//            m2.getUsername();// 강제 초기화
//            Hibernate.initialize(m2);// 강제 초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(m2));

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "1111"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street1", "1122"));
            member.getAddressHistory().add(new AddressEntity("old2", "street2", "11332"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============== START ===============");
            Member findMember = em.find(Member.class, member.getId());

            //homeCity -> newCity
            //findMember.getHomeAddress().setCity("newCity"); (X) : 값타입은 통으로 바꿔야 한다.
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
            
            //치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new AddressEntity("old1", "street1", "1122")); //hashcode 중요
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street1", "1122"));

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
