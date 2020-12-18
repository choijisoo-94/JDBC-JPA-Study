package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

//step02 - named query 실습 Entity
//사번으로 사원 검색, 이름으로 사원검색, 사번과 이름으로 사원 검색
@NamedQuery(query="select e from Employee e where e.eid=:eid" , name ="Employee.findByEmpno")
//@NamedQuery(query= , name ="Employee.findByEname")
@NamedQuery(query="select e from Employee e where e.eid=:eid and e.ename=:ename", name ="Employee.findByEmpnoAndEname")

@Entity
public class Employee {
	@Id
	@Column(name="empno")
	private int eid;
	
	@Column(name="ename", length=20)
	private String ename;
	
	@Column(name="sal")
	private int salary;
	
	@Column(name="deptno")
	private int department;

	
	@Override
	public String toString() {
		return "Employee [사원 아이디 =" + eid + ", 사원명 =" + ename + ", 급여 =" + salary + ", 부서=" + department + "]";
	}

		
}




//step01 - JPQL 실습 Entity
//@Entity
//public class Employee {
//	@Id
//	@Column(name="empno")
//	private int eid;
//	
//	@Column(name="ename", length=20)
//	private String ename;
//	
//	@Column(name="sal")
//	private int salary;
//	
//	@Column(name="deptno")
//	private int department;
//
//	
//	@Override
//	public String toString() {
//		return "Employee [사원 아이디 =" + eid + ", 사원명 =" + ename + ", 급여 =" + salary + ", 부서=" + department + "]";
//	}
//
//		
//}

