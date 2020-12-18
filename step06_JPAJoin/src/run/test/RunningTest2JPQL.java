package run.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import step03.entity.Member;
import step03.entity.Team;
import util.PublicCommon;

public class RunningTest2JPQL {
	
	
	//simple select
	//20살 미만의 멤버 검색
	//select m from Member m where m.age < 20
	private static void simpleQuery(EntityManager em) {
		List<Member> resultList 
		= em.createQuery("select m from Member m where m.age > 20", Member.class).getResultList();
	
		resultList.forEach(m -> System.out.println(m));
	
	}

	//join
	//첫번째 실습 : Member의 team id 타입인 Team 의 teamName 변수값을 검색하는 join 문장
	/*m.teamId t
	 * Member 객체의 teamId 변수(Team 타입)
	 * Team t = m.teamId;
	 * 
	 *? teaId값을 where 조건식으로 반영해 보기
	 */
	private static void joinQuery(EntityManager em) {
		List<Member> resultList 
		= em.createQuery("select m from Member m join m.teamId t where t.teamId=1L").getResultList();
		resultList.forEach(v -> System.out.println(v));
	}
	
	
	@Test
public void runningJPQL() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
		
			
			Team t1 = Team.builder().teamName("TeamA").members(new ArrayList<Member>()).build();
			
		
			Member m1 = Member.builder().name("유재석").age(11).teamId(t1).build();
			Member m2 = Member.builder().name("이영자").age(22).teamId(t1).build();
			Member m3 = Member.builder().name("준형").age(15).teamId(t1).build();
			Member m4 = Member.builder().name("정민").age(10).teamId(t1).build();
			Member m5 = Member.builder().name("민건").age(23).teamId(t1).build();
			
			t1.getMembers().add(m1);
			t1.getMembers().add(m2);
			t1.getMembers().add(m3);
			t1.getMembers().add(m4);
			t1.getMembers().add(m5);
			
			em.persist(t1); // insert 문장 생성 + 스냅샷으로 저장 : 영속성 컨텍스트에 저장
			em.persist(m1);
			em.persist(m2);
			em.persist(m3);
			em.persist(m4);
			em.persist(m5);
			
			em.flush();
			em.clear();
			
			tx.commit(); 
			
			
			
			//jpql test
			//simpleQuery(em);
			joinQuery(em);
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
	
}


