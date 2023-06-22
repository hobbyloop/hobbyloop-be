package hobbyloop.backend.api.controller.ticket;

import java.time.LocalDate;

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
public class UserTicketInfoResponseDTO {
	private String ticketImageUrl;
	private String ticketName;
	private LocalDate startDate;
	private LocalDate endDate;

	public static UserTicketInfoResponseDTO from(UserTicket userTicket) {
		return UserTicketInfoResponseDTO.builder()
			.ticketImageUrl(userTicket.getTicket().getTicketImageUrl())
			.ticketName(userTicket.getTicket().getTicketName())
			.startDate(userTicket.getStartDate())
			.endDate(userTicket.getEndDate()).build();
	}
}
