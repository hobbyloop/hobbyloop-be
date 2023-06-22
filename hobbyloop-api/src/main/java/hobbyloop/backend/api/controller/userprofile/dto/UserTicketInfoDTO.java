package hobbyloop.backend.api.controller.userprofile.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import hobbyloop.backend.domain.ticket.UserTicket;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTicketInfoDTO {
	@ApiModelProperty(name = "이용권 이미지")
	private String ticketImageUrl;

	@ApiModelProperty(name = "업체명", example = "에이블짐 창신점")
	private String centerName;

	@ApiModelProperty(name = "이용권의 남은 횟수", example = "9")
	private int remainingCounts;

	@ApiModelProperty(name = "종료일", example = "2023-05-24")
	private LocalDate endDate;

	public static UserTicketInfoDTO from(UserTicket userTicket) {
		return UserTicketInfoDTO.builder()
			.ticketImageUrl(userTicket.getTicket().getTicketImageUrl())
			.centerName(userTicket.getTicket().getCenter().getCenterName())
			.remainingCounts(userTicket.getRemainingCounts())
			.endDate(userTicket.getEndDate())
			.build();
	}

	public static List<UserTicketInfoDTO> from(List<UserTicket> userTickets) {
		return userTickets.stream()
			.map(UserTicketInfoDTO::from)
			.collect(Collectors.toList());
	}
}
