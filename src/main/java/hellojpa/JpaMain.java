package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            */

            /*
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("result = " + (findMember2 == findMember1));
            */

            /*
            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZ");
            */

            /*
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush(); // commit 되기 전에 쿼리를 날린다.
            */

            /*
            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); // 준영속 상태 : 영속성 컨텍스트에서 더 이상 관리하지 않는다.
            */

            /*//저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);*/

            /*Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team); //연관관계의 주인에 값 설정
            em.persist(member);*/

            //team.getMembers().add(member);

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);

            //Team findTeam = em.find(Team.class, team.getId()); //1차 캐시

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
