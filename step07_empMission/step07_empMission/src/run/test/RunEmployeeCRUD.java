//employee table crud 로직 정상 실행되게 완벽하게 구현
//개별 메소드로 개발 차후에 리펙토링 해야 함

package run.test;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import lombok.Builder;
import model.domain.Employee;
import util.PublicCommon;


@Builder
public class RunEmployeeCRUD {
	//create
	//@Test
	public static void createEmployee(String ename, int salary, String department) {

		EntityManager entitymanager = PublicCommon.getEntityManager();

		EntityTransaction tx = entitymanager.getTransaction();
		tx.begin();

		try {
			Employee e1 = Employee.builder().ename(ename).salary(salary).department(department).build();

			entitymanager.persist(e1);

			//entitymanager.flush();
			//entitymanager.clear();

			tx.commit();

		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			entitymanager.close();
		}
	}

	//update
	//@Test
	@Transactional
	public void updateEmployee(int eid,String ename, int salary, String deptname) {

		EntityManager entitymanager = PublicCommon.getEntityManager();
		EntityTransaction tx = entitymanager.getTransaction();
		tx.begin();

		Employee employee = entitymanager.find(Employee.class, eid);
		// before update
		System.out.println("update 전 : " + employee);

		//		Optional<Employee> employee = employeeRepository.findById(1);
		//			employee.ifPresent(selectEmployee ->{
		//			selectEmployee.setEid(1202);
		//			selectEmployee.setEid("park");
		//			selectEmployee.setSalary(46000);
		//			selectEmployee.setDepartment("HR Department");
		//			Employee newEmployee = EmployeeRepository.save(selectEmployee);
		//			System.out.println("Employ : " + newEmployee);
		//		};

		employee.setEname(ename);
		employee.setSalary(salary);
		employee.setDepartment(deptname);

		entitymanager.persist(employee);

		tx.commit();

		// after update
		System.out.println("update 후 : " + employee);
		System.out.println(employee);
		entitymanager.close();
	}

	public static void updateEmployeeSalary(int eid, int salary) {

		EntityManager entitymanager = PublicCommon.getEntityManager();
		EntityTransaction tx = entitymanager.getTransaction();
		tx.begin();

		Employee employee = entitymanager.find(Employee.class, eid);
		
		// before update
		System.out.println("update 전 : " + employee);

		employee.setSalary(salary);

		entitymanager.persist(employee);

		tx.commit();

		// after update
		System.out.println("update 후 : " + employee);
		System.out.println(employee);
		entitymanager.close();
	}

	//select
	//@Test
	public static void findElement(EntityManager em, int eid) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Employee employee = em.find(Employee.class, eid);

		if(employee != null) {
			//System.out.println("employee ID = " + employee.getEid());
			//System.out.println("employee NAME = " + employee.getEname());
			//System.out.println("employee SALARY = " + employee.getSalary());
			//System.out.println("employee DESIGNATION = " + employee.getDepartment());
			System.out.println(employee);
		}else {
			System.out.println("검색 요청한 직원은 미존재합니다");
		}
	}

	//delete
	//@Test
	@Transactional
	public static void deleteElement(int eid) {

		EntityManager entitymanager = PublicCommon.getEntityManager();

		EntityTransaction tx = entitymanager.getTransaction();
		tx.begin();

		Employee employee = entitymanager.find(Employee.class, eid);
		entitymanager.remove(employee);

		entitymanager.getTransaction().commit();

		entitymanager.close();
	}

	public static void main(String[] args) {
		EntityManager em= PublicCommon.getEntityManager();

		createEmployee("kim",2000,"개발부");  //실행 직후 none로 대체하기
		createEmployee("Lee",12000,"교부");  //실행 직후 none로 대체하기
		updateEmployeeSalary(1,60000);

		findElement(em, 10);
		deleteElement(1);
	}

}
