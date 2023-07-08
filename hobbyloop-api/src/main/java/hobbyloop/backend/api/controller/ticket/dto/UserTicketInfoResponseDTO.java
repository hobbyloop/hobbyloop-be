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
	@ApiModelProperty(name = "이용권 이미지 url")
	private String ticketImageUrl;

	@ApiModelProperty(name = "이용권 명", example = "6대1 필라테스 수업")
	private String ticketName;

	@ApiModelProperty(name = "이용권 기간 시작 날짜", example = "2023-06-20")
	private LocalDate startDate;

	@ApiModelProperty(name = "이용권 기간 끝 날짜", example = "2023-08-30")
	private LocalDate endDate;

	public static UserTicketInfoResponseDTO from(UserTicket userTicket) {
		return UserTicketInfoResponseDTO.builder()
			.ticketImageUrl(userTicket.getTicket().getTicketImageUrl())
			.ticketName(userTicket.getTicket().getTicketName())
			.startDate(userTicket.getStartDate())
			.endDate(userTicket.getEndDate()).build();
	}
}
