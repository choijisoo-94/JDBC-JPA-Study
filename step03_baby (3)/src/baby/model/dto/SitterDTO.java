package baby.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SitterDTO {

	private String name;
	private String gender;
	private int age;
	private String location;
	private String sitterid;
	private int orderid;
	private String phonenumber;
	private String certification;
	private String experience;
	private int hourlywage;
	private String duration;
	private String clearance;

	public SitterDTO() {
	}

	public SitterDTO(String name, String gender, int age, String location, String sitterid, int orderid,
			String phonenumber, String certification, String experience, int hourlywage, String duration,
			String clearance) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.sitterid = sitterid;
		this.orderid = orderid;
		this.phonenumber = phonenumber;
		this.certification = certification;
		this.experience = experience;
		this.hourlywage = hourlywage;
		this.duration = duration;
		this.clearance = clearance;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SitterDTO [name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", location=");
		builder.append(location);
		builder.append(", sitterid=");
		builder.append(sitterid);
		builder.append(", orderid=");
		builder.append(orderid);
		builder.append(", phonenumber=");
		builder.append(phonenumber);
		builder.append(", certification=");
		builder.append(certification);
		builder.append(", experience=");
		builder.append(experience);
		builder.append(", hourlywage=");
		builder.append(hourlywage);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", clearance=");
		builder.append(clearance);
		builder.append("]");
		return builder.toString();
	}

}