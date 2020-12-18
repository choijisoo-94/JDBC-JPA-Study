//step02 실습 - 컬럼 설정 확장 & 시퀀스명 자동 생성 및 활용

package step02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) //시퀀스 반영하는 방법
	private long id; 
	
	@Column(length=20, nullable=false) //  NOT NULL VARCHAR2(20)
	private String name;
	

	@Column(length=6, nullable=false)
	private String gender;
	
	@Column(nullable=false)
	private int age; // NOT NULL NUMBER(10)
	
}

/*
 * @Id
 * private long id;
 * 
 * @Column(length=20)
 * private String name;
 * 
 *
 *
 * 
 * ID					NOT NULL NUMBER(19)
 * NAME					VARCHAR2(20)
*/