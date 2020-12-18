package model.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
	@Id
	@Column
	private int empno;

	@Column
	private String ename;

	@Column
	private int sal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="deptNo")
	private Dept deptNo;


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empno=");
		builder.append(empno);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", sal=");
		builder.append(sal);
		builder.append(", deptNo=");
		builder.append(deptNo.getDeptid());
		builder.append("]");
		return builder.toString();
	}





}

