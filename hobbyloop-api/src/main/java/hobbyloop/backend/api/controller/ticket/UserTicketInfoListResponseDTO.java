package hobbyloop.backend.api.controller.ticket;

import java.util.List;
import java.util.stream.Collectors;

import hobbyloop.backend.domain.ticket.UserTicket;
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
	private String centerName;
	private List<UserTicketInfoResponseDTO> ticketInfos;

	public static UserTicketInfoListResponseDTO from(String centerName, List<UserTicket> userTickets) {

		return UserTicketInfoListResponseDTO.builder()
			.centerName(centerName)
			.ticketInfos(userTickets.stream().map(UserTicketInfoResponseDTO::from).collect(Collectors.toList()))
			.build();
	}
}
