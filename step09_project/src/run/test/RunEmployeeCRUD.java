package run.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Employee;
import util.PublicCommon;


//public class RunEmployeeCRUD {
////	create
//	public void createEmployee(EntityManager em, int eid) {
//
//		Employee employee = em.
//		
//		EntityTransaction tx = 
//		
//	}
//
//	//update
////	//@Test
////	//@Transactional
//	//public void updateEmployeeSalary(EntityManager em) {
//		
//		Employee employee = em.find(Employee.class, 7369);
////		 before update
//		System.out.println("salary update 전 : " + employee);
//		if(employee != null) {
//			
//			employee.setSal(5000);
//			System.out.println("salary update 후 : " + employee);	
//		}else {
//			System.out.println("삭제 요청한 직원이 없습니다.");
//		}
//		// after update
//	}

//	public static void updateEmployeeSalaryDeptId(EntityManager em, int empno, Long deptid) {
//
//		Employee employee = em.find(Employee.class, empno);
//
//		// before update
//		System.out.println("deptid update 전 : " + employee);
//	}
//	
//		//select
//		//@Test
//		public static void findElement(EntityManager em, int eid) {
//			Employee employee = em.find(Employee.class, eid);
//			if(employee != null) {
//				System.out.println(employee);
//			}else {
//				System.out.println("검색 요청한 직원은 미존재합니다.");
//			}
//		}
//
//		//delete
//		//@Test
//		//@Transactional
//		public static void deleteEmployeeElement(EntityManager em, int eid) {
//
//			Employee employee = em.find(Employee.class, eid);
//
//			em.remove(employee);
//
//		}
//
//		public static void deleteDeptElement(EntityManager em, int deptid) {
//
//			Dept dep = em.find(Dept.class, deptid);
//			em.remove(dep);
//
//		}
//		@Test
//		public void runningJPQL() {
//
//			EntityManager em = PublicCommon.getEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			tx.begin();
//
//			try {
//				createEmployee(em, 1234);//create
//				// JPQL
////				findElement(em); // select
//				updateEmployeeSalary(em); // update
////				deleteElement(em); // delete
////				findElementAll(em); // select all
//
//				tx.commit(); // 실제 insert
//			} catch (Exception e) {
//				tx.rollback();
//				e.printStackTrace();
//			} finally {
//				em.close();
//			}
//		}
//
//	}
