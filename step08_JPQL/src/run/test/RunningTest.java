package run.test;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import model.domain.Employee;
import util.PublicCommon;
public class RunningTest {
	@Test
	public void runNamedQueryTest() {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			Employee e = (Employee)em.createNamedQuery("Employee.findByEmpno").setParameter("eid", 7369).getSingleResult();
			System.out.println(e);
			
			e =(Employee)em.createNamedQuery("Employee.findByEmpnoAndEname").setParameter("eid", 7369).setParameter("ename", "SMITH").getSingleResult();
			System.out.println(e);

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	
	
	//@Test
	public void runJPQL() {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			// select lower
			String jpql = "select LOWER(e.ename) from Employee e";
			List<String> list = em.createQuery(jpql).getResultList();
			list.forEach(v -> System.out.println(v));
			// max
			jpql = "select max(e.salary) from Employee e";
			int maxSal = (int) em.createQuery(jpql).getSingleResult();
			System.out.println(maxSal);
			// between ~ and
			jpql = "select e from Employee e where e.salary between 800 and 3000";
			List<Employee> list2 = em.createQuery(jpql).getResultList();
			list2.forEach(v -> System.out.println(v));
			// like 연산 대문자 M 시작하는 모든 사원의 모든 정보 검색
			jpql = "select e from Employee e where e.ename like 'M%'";
			List<Employee> list3 = em.createQuery(jpql).getResultList();
			list3.forEach(v -> System.out.println(v));
			// 사원명을 오름차순으로 정렬해서 사원명만 출력
			jpql = "select e.ename from Employee e order by e.ename asc";
			List<String> list4 = em.createQuery(jpql).getResultList();
			list4.forEach(v -> System.out.println(v));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}