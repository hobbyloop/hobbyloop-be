package hobbyloop.backend.domain.ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketModelDTO {
	private Ticket ticket;
	private int maxCouponValue;
	private int basicReward;
	private int usablePoint;
	private int textReviewReward = 1000;
	private int photoReviewReward = 1000;

	public TicketModelDTO(Ticket ticket, int maxCouponValue, int basicReward) {
		this.ticket = ticket;
		this.maxCouponValue = maxCouponValue;
		this.basicReward = basicReward;
	}

	public void updateUsablePoint(int userPoint) {
		this.usablePoint = userPoint;
	}
}
