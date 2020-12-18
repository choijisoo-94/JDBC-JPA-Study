package run.test;

import step03.entity.Member;
import step03.entity.Team;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import lombok.Builder;
//import step01.entity.Team;
import util.PublicCommon;

@Builder
public class RunningTest {
	
	//step05 - 즉시로딩, 늦은로딩
	@Test
public void runningTest4() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
		
			
			Team t1 = Team.builder().teamName("TeamA").members(new ArrayList<Member>()).build();
			
		
			Member m1 = Member.builder().age(20).name("유재석").age(11).teamId(t1).build();
			Member m2 = Member.builder().age(20).name("이영자").age(22).teamId(t1).build();
		
			
			t1.getMembers().add(m1);
			t1.getMembers().add(m2);
			
			
			em.persist(t1); // insert 문장 생성 + 스냅샷으로 저장 : 영속성 컨텍스트에 저장
			em.persist(m1);
			em.persist(m2);
			
			
			//검색 - 영속성 컨텍스트에서 검색 시도, 동일한 데이터 존재할 경우 db까지 select 실행 안 함
			//영속성 컨텍스트 초기화 - 잔존된 데이터 삭제 따라서 검색 요청시 무조건 db에 select 실행
			//생략시 select 문장 실행 안함 : 전제조건 : 
//			em.flush();
//			em.clear();
			
			Member sm = em.find(Member.class, m1.getMemberId());
			System.out.println("검색한 멤버 명 : " + sm.getName()); //검색한 멤버 명 : 유재석
			System.out.println(sm.getTeamId().getTeamName()); //TeamA

			
			tx.commit(); //실제 insert
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
	// step04 - 일대다, 다대일 관계에서의 Entity 클래스 설계의 주의사항 
	//@Test
//	public void runningTest4() {
//		
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		try {
//			//???
//			
//			Team t1 = Team.builder().teamName("TeamA").members(new ArrayList<Member>()).build();
//			
//		
//			Member m1 = Member.builder().age(20).name("유재석").age(11).teamId(t1).build();
//			Member m2 = Member.builder().age(20).name("이영자").age(22).teamId(t1).build();
//		
//			
//			t1.getMembers().add(m1);
//			t1.getMembers().add(m2);
//			
//			
//			em.persist(t1);
//			em.persist(m1);
//			em.persist(m2);
//			
//			//--- 검색 추가
//			Team teamInfo = em.find(Team.class, t1.getTeamId());
//			System.out.println("팀에 소속된 멤버 수 : " + teamInfo.getMembersCount());
//			
//			System.out.println("멤버 검색 ----");
//			Member sm = em.find(Member.class, 2L);
//			
//			System.out.println(sm.getName());
//			//메모리 문제 이슈 체감 
//			System.out.println(sm);
//			
//			tx.commit();
//			
//		} catch (Exception e) {
//			tx.rollback(); //꼭 넣어주세요
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
//
//	}
//	
//	@Test
//	public void runningTest() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//
//		try {
//			Team t1 = Team.builder().teamName("team A").build();
//			em.persist(t1);
//
////			Team t2 = Team.builder().teamName("team B").build();
////			em.persist(t2);
//
//			// teamid같게 member객체 생성
//			Member m1 = Member.builder().age(20).name("유재석").teamId(t1).build();
//			em.persist(m1);
//
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
//
//	}
	
	
}
