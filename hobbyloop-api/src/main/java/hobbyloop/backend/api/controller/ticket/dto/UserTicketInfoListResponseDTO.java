package hobbyloop.backend.api.controller.ticket.dto;

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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserTicketInfoListResponseDTO {
	@ApiModelProperty(name = "센터명", example = "에이블짐 1호점")
	private String centerName;

	@ApiModelProperty(name = "사용자의 티켓 정보 List")
	private List<UserTicketInfoResponseDTO> ticketInfos;

	public static UserTicketInfoListResponseDTO from(String centerName, List<UserTicket> userTickets) {
		List<UserTicketInfoResponseDTO> userTicketInfoFromUserTicket =
			userTickets.stream()
				.map(UserTicketInfoResponseDTO::from)
				.collect(Collectors.toList());

		return UserTicketInfoListResponseDTO.builder()
			.centerName(centerName)
			.ticketInfos(userTicketInfoFromUserTicket)
			.build();
	}
}
