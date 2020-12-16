package baby.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FeedbackDTO {

	private String feedbackid;
	private int score;
	private int count;

	public FeedbackDTO() {}

	public FeedbackDTO(String feedbackid, int score, int count) {
		this.feedbackid = feedbackid;
		this.score = score;
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeedbackDTO [feedbackid=");
		builder.append(feedbackid);
		builder.append(", score=");
		builder.append(score);
		builder.append(", count=");
		builder.append(count);
		builder.append("]");
		return builder.toString();
	}

}