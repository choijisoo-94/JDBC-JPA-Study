package run.test;


import step02.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;



public class MemberTest {
	
	@Test
	public void crudTest() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDBUse");
		
	
		EntityManager em = emf.createEntityManager();
		
		//insert/update/delete
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//? id는 시퀀스 즉 oracle db 자체적으로 자동 증가시키는 컬럼
		// client가 입력 못하는 수정 불가인 데이터로 간주
		//? 객체 생성
		Member m1 = new Member();
		m1.setName("유재석");
		m1.setAge(47);
		m1.setGender("남자");
		
		Member m2 = new Member();
		m2.setName("강호동");
		m2.setAge(47);
		m2.setGender("남자");
		
		
		em.persist(m1);
		em.persist(m2);
		
		tx.commit(); 
		
		em.close();
		emf.close();
	}
}
