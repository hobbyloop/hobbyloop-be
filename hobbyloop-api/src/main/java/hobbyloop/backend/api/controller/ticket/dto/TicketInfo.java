package hobbyloop.backend.api.controller.ticket.dto;

import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.ticket.UserTicket;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class TicketInfo {
	@ApiModelProperty(name = "이용권 이미지 url")
	private String ticketImageUrl;

	@ApiModelProperty(name = "이용권 명", example = "6대1 필라테스 수업")
	private String ticketName;

	@ApiModelProperty(name = "횟수", example = "10")
	private int count;

	public static TicketInfo from(UserTicket userTicket) {
		return TicketInfo.builder()
			.ticketImageUrl(userTicket.getTicket().getTicketImageUrl())
			.ticketName(userTicket.getTicket().getTicketName())
			.count(userTicket.getRemainingCounts()).build();
	}

	public static TicketInfo from(Ticket ticket) {
		return TicketInfo.builder()
			.ticketImageUrl(ticket.getTicketImageUrl())
			.ticketName(ticket.getTicketName())
			.count(ticket.getCount()).build();
	}
}
