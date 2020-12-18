package step03.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString

@SequenceGenerator(name="member_seq_gen", sequenceName="member_seq_id",
initialValue=1, allocationSize=50)
@Builder
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="member_seq_gen")
	@Column(name="member_Id")
	private Long memberId;
	
	@Column(length=20)
	private String name;
	
	private int age;
	
	//여러명의 Member는 하나의 Team에 포함 다:1관계
	@ManyToOne(fetch=FetchType.LAZY)
	//@ManyToOne
	@JoinColumn(name="team_id") 
	private Team teamId;

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", age=" + age + ", teamID=" + teamId.getTeamId()+ ",teamName="+teamId.getTeamName()+"]";
	}

	
	
}

/*1번 TEST - Member table의 정보만 find()
 * @ManyToOne(fetch=FetchType.LAZY)
 * 
 * select member0_.member_Id as member_I1_0_0_, 
 * member0_.age as age2_0_0_, member0_.name as name3_0_0_, 
 * member0_.team_id as team_id4_0_0_ from Member member0_ where member0_.member_Id=?*/

/*@ManyToOne
 * 
 * select member0_.member_Id as member_I1_0_0_,
 *  member0_.age as age2_0_0_, member0_.name as name3_0_0_, 
 *  member0_.team_id as team_id4_0_0_,
 *   team1_.team_id as team_id1_1_1_,
 *    team1_.team_name as team_nam2_1_1_ from Member member0_,
 *     Team team1_ where member0_.team_id=team1_.team_id(+) and member0_.member_Id=?
 *     
 *2번 TEST - Member table의 정보 -> 해당 Member가 소속된 Team의 Team명(team_name)find()
 *@ManyToOne(fetch=FetchType.LAZY)    
 *	select member0_.member_Id as member_I1_0_0_, 
 *member0_.age as age2_0_0_, member0_.name as name3_0_0_,
 * member0_.team_id as team_id4_0_0_ from Member member0_ where member0_.member_Id=?
 *     
 *     select team0_.team_id as team_id1_1_0_, 
 *     team0_.team_name as team_nam2_1_0_
 *      from Team team0_ where team0_.team_id=? 
 *      
 *     
 *     
 *     
 */
