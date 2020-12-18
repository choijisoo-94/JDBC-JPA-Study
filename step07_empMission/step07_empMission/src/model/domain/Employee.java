package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;

@Builder
@SequenceGenerator(name="employee_seq_gen", sequenceName="employee_seq_eid", 
initialValue=1, allocationSize=50)
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq_gen")	
	@Column(name="employee_Eid")
	private int eid;

	@Column(length=20)
	private String ename;

	private int salary;

	@Column(length=20)
	private String department;

	public Employee() {}
	public Employee(int eid, String ename, int salary, String department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.department = department;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String deg) {
		this.department = deg;
	}

	@Override
	public String toString() {
		return "Employee [사원 아이디 =" + eid + ", 사원명 =" + ename + ", 급여 =" + salary + ", 부서=" + department + "]";
	}

		
	}

