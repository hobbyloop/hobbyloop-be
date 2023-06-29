package hobbyloop.backend.api.controller.ticket.dto;

import java.time.LocalDate;

import hobbyloop.backend.domain.ticket.UserTicket;
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
public class UserTicketInfoResponseDTO {
	private TicketInfo ticketInfo;

	@ApiModelProperty(name = "이용권 기간 시작 날짜", example = "2023-06-20")
	protected LocalDate startDate;

	@ApiModelProperty(name = "이용권 기간 끝 날짜", example = "2023-08-30")
	protected LocalDate endDate;

	public static UserTicketInfoResponseDTO from(UserTicket userTicket) {
		TicketInfo ticketInfo = TicketInfo.from(userTicket);
		return UserTicketInfoResponseDTO.builder()
			.ticketInfo(ticketInfo)
			.startDate(userTicket.getStartDate())
			.endDate(userTicket.getEndDate())
			.build();
	}
}
