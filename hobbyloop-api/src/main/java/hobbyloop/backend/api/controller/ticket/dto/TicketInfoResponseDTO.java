package hobbyloop.backend.api.controller.ticket.dto;

import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.ticket.TicketModelDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TicketInfoResponseDTO {
	private TicketInfo ticketInfo;

	@ApiModelProperty(name = "이용권 사용 가능 일수", example = "30")
	private int days;

	@ApiModelProperty(name = "기본 구매가", example = "200000")
	private int basicPrice;

	@ApiModelProperty(name = "쿠폰 할인 가격", example = "9000")
	private int couponDiscount;

	@ApiModelProperty(name = "총 결제 금액", example = "191000")
	private int totalPrice;

	@ApiModelProperty(name = "구매 확정시 기본 적립", example = "2300")
	private int basicPoint;

	@ApiModelProperty(name = "총 예상 적립", example = "4300")
	private int totalPoint;

	@ApiModelProperty(name = "구매 확정시 기본 적립", example = "1000")
	private int textReviewRewardPoint;

	@ApiModelProperty(name = "구매 확정시 기본 적립", example = "1000")
	private int photoReviewRewardPoint;

	@ApiModelProperty(name = "최대 사용 가능 포인트", example = "0")
	private int usablePoint;

	public static TicketInfoResponseDTO from(TicketModelDTO ticketModelDTO) {
		Ticket fromTicketModelDTO = ticketModelDTO.getTicket();
		return TicketInfoResponseDTO.builder()
			.ticketInfo(TicketInfo.from(fromTicketModelDTO))
			.days(fromTicketModelDTO.getDays())
			.basicPrice(fromTicketModelDTO.getPrice())
			.couponDiscount(ticketModelDTO.getMaxCouponValue())
			.totalPrice(
				fromTicketModelDTO.getPrice() - ticketModelDTO.getMaxCouponValue() - ticketModelDTO.getUsablePoint())
			.basicPoint(fromTicketModelDTO.getBasicReward())
			.totalPoint(ticketModelDTO.getUsablePoint() + ticketModelDTO.getTextReviewReward()
				+ ticketModelDTO.getPhotoReviewReward())
			.usablePoint(ticketModelDTO.getUsablePoint()).build();
	}
}
