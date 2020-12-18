//employee table crud 로직 정상 실행되게 완벽하게 구현
//개별 메소드로 개발 차후에 리펙토링 해야 함

package run.test;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Employee;
import util.PublicCommon;

	/*
	 * sql문장으로 
		존재하는 employee table과 Dept table이 있는 가정하에 
		Employee의 deptno는 Dept의 deptno를 fk 로 참조
		emp와 dept 동적으로 간주
		alter 명령어 사용
		alter table employee add constraint deptno_employee_fk foreign key(deptno) references dept(deptno);

		sql 문으로 사전에 table 제약 조건 등 설정하고
		crud 로직만 구현
		
		최적의 코드로 개발하기
		-소요시간
		2시간
		
	 */
	//crud

public class RunEmployeeCRUD {

	public static void insertEmployee(EntityManager em) {
		System.out.println("=== insert ===");
//		Employee e1 = Employee.builder().eid(1201)
//										.ename("Gopal").salary(4000)
//										.department(10).build();
		Employee e2 = Employee.builder().eid(1202)
				.ename("Hopal").salary(4500)
				.department(10).build();
//		em.persist(e1);
		em.persist(e2);
	}
	
//	public static void updateEmployee(EntityManager em) {
//		Employee e = (Employee) em.createNamedQuery("Employee.updateSalaryByEname").setParameter("sal", 4600).setParameter("eid", 1201);
//		System.out.println(e);
//	}
	
	public static void updateEmployee(EntityManager em) {
		System.out.println("=== update ===");
		Employee employee = em.find(Employee.class, 1201);
		
		if(employee != null) {
		// before update
		System.out.println("update 전 : " + employee);

		employee.setSalary(4700);

		// after update
		System.out.println("update 후 : " + employee);
		}else {
			System.out.println("수정 요청한 직원은 미존재합니다");
		}
	}

	// select
	public static void findElement(EntityManager em) {
		System.out.println("=== select ===");
		List<Employee> resultList = em.createQuery("select e from Employee e where e.eid = 1201", Employee.class)
				.getResultList();
		if (resultList != null) {
			resultList.forEach(e -> System.out.println("JPQL SELECT" + e));
		} else {
			System.out.println("검색 요청한 직원은 미존재합니다");
		}
	}
	public static void findElementAll(EntityManager em) {
		System.out.println("=== select All ===");
		List<Employee> resultList = em.createQuery("select e from Employee e", Employee.class)
				.getResultList();
		if (resultList != null) {
			resultList.forEach(e -> System.out.println("JPQL SELECT" + e));
		} else {
			System.out.println("검색 요청한 직원은 미존재합니다");
		}
	}

	// delete
	public static void deleteElement(EntityManager em) {
		System.out.println("=== delete ===");
		Employee employee = em.find(Employee.class, 1201);
		if (employee != null) {
		em.remove(employee);
		} else {
			System.out.println("삭제 요청한 직원은 미존재합니다");
		}
	}

	@Test
	public void runningJPQL() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			insertEmployee(em);//create
			// JPQL
			findElement(em); // select
			updateEmployee(em); // update
			deleteElement(em); // delete
			findElementAll(em); // select all

			tx.commit(); // 실제 insert
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
//		createEmployee();  //실행 직후 none로 대체하기
		// updateEmployee();
		// findElement();
		// deleteElement();
	}

}
