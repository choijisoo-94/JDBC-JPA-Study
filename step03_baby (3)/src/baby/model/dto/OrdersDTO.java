package baby.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrdersDTO {
	
	private int orderid;
	private String parentid;
	private String sitterid;
	private String childid;
	private int hourlywage;
	private String duration;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDTO [ordersid=");
		builder.append(orderid);
		builder.append(", parentid=");
		builder.append(parentid);
		builder.append(", sitterid=");
		builder.append(sitterid);
		builder.append(", childid=");
		builder.append(childid);
		builder.append(", hourlywage=");
		builder.append(hourlywage);
		builder.append(", duration=");
		builder.append(duration);
		builder.append("]");
		return builder.toString();
	}


	

}
