package hobbyloop.backend.domain.center;

import lombok.Getter;

@Getter
public class CenterDTO {
	private Long centerId;
	private String centerName;
	private String repImageUrl;
	private String address;
	private double score;
	private long tickets;
	private boolean isBookmarked;

	public CenterDTO(Long centerId, String centerName, String repImageUrl, String address, double score, long tickets,
		boolean isBookmarked) {
		this.centerId = centerId;
		this.centerName = centerName;
		this.repImageUrl = repImageUrl;
		this.address = address;
		this.score = score;
		this.tickets = tickets;
		this.isBookmarked = isBookmarked;
	}
}

