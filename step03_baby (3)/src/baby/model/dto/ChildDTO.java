package baby.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildDTO {

	private String name;
	private String gender;
	private int age;
	private String childid;
	private String parentid;

	public ChildDTO() {
	}

	public ChildDTO(String name, String gender, int age, String childid, String parentid) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.childid = childid;
		this.parentid = parentid;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChildDTO [name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", childid=");
		builder.append(childid);
		builder.append(", parentid=");
		builder.append(parentid);
		builder.append("]");
		return builder.toString();
	}

}
