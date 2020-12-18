package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PublicCommon {
	//db driver 처럼 한번만 메모리에 생성 후 저장 및 쭉~ 쭉 재사용
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("oracleDBuse");
	}
	
	//? EntityManager 반환
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	//? 자원반환
	/* emf만 close?
	 * emf? EntityManager close?
	 * EntityManager close?
	 * 	- 28line 한 문장만 실행한다면... 메소드 분리해서 호출? 사용했던 각 메소드에서 em.close() 코드로 처리?
	 */
	
	public static void close(EntityManager em) {
		emf.close();
	}
}
