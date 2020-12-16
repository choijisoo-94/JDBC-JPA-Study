package baby.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PreferenceDTO {
	private String preferenceid;
	private String sitterid;
	private int hourlywage;
	private String duration;
	
	public PreferenceDTO() {}

	public PreferenceDTO(String preferenceid, String sitterid, int hourlywage, String duration) {
		this.preferenceid = preferenceid;
		this.sitterid = sitterid;
		this.duration = duration;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PreferenceDTO [preferenceid=");
		builder.append(preferenceid);
		builder.append(", sitterid=");
		builder.append(sitterid);
		builder.append(", hourlywage=");
		builder.append(hourlywage);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	

}
