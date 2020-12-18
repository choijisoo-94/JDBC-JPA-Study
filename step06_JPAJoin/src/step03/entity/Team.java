// 여러명의 선수를 하나의 Team 이 보유



package step03.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
@SequenceGenerator(name="team_seq_gen", sequenceName="team_seq_id",
					initialValue=1, allocationSize=50)
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="team_seq_gen")
	@Column(name="team_id") //Team table의 컬럼명
	private Long teamId;
	
	
	@Column(length=20, name="team_name")
	private String teamName;
	
	//다수의 Member 를 보유 가능한 변수 추가 선언
	//포함되는 Member의 연관된 변수명을 mappedBy 속성값으로 적용해야 함
	@OneToMany(mappedBy="teamId") //1:다
	private List<Member> members;
	
	//멤버 수를 반환하는 메소드
	public int getMembersCount() {
		return members.size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [teamId=");
		builder.append(teamId);
		builder.append(", teamName=");
		builder.append(teamName);
		builder.append(", members=");
		builder.append(members);  //ArrayList들의 toString() 호출하는 상황
		builder.append("]");
		return builder.toString();
	}
	
	
}
