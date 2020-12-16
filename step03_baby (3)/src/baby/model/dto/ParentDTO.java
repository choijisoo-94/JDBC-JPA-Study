package baby.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentDTO {

	private String name;
	private String gender;
	private int age;
	private String location;
	private String parentid;
	private String phonenumber;
	private String childid;
	private String clearance;

	public ParentDTO() {
	}

	public ParentDTO(String name, String gender, int age, String location, String parentid, String phonenumber,
			String childid, String clearance) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.parentid = parentid;
		this.phonenumber = phonenumber;
		this.childid = childid;
		this.clearance = clearance;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParentDTO [name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", location=");
		builder.append(location);
		builder.append(", parentid=");
		builder.append(parentid);
		builder.append(", phonenumber=");
		builder.append(phonenumber);
		builder.append(", childid=");
		builder.append(childid);
		builder.append(", clearance=");
		builder.append(clearance);
		builder.append("]");
		return builder.toString();
	}

}