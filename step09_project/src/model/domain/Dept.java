package model.domain;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Dept {
	
	@Id
	@Column
	private Long deptid;
	
	@Column
	private String deptName;
	
	@Column
	private String loc;

	@OneToMany(mappedBy = "deptNo")
	private List<Employee> employee;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dept [deptid=");
		builder.append(deptid);
		builder.append(", deptName=");
		builder.append(deptName);
		builder.append(", loc=");
		builder.append(loc);
		builder.append("]");
		return builder.toString();
	}

}
