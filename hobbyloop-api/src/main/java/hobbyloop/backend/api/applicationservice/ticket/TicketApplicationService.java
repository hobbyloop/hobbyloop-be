package hobbyloop.backend.api.applicationservice.ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hobbyloop.backend.api.controller.ticket.dto.CreateTicketRequestDTO;
import hobbyloop.backend.api.controller.ticket.dto.UserTicketInfoListResponseDTO;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.center.CenterService;
import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.ticket.TicketService;
import hobbyloop.backend.domain.ticket.UserTicket;
import hobbyloop.backend.domain.ticket.UserTicketService;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketApplicationService {
	private final UserService userService;
	private final TicketService ticketService;
	private final UserTicketService userTicketService;

	private final CenterService centerService;

	public List<UserTicketInfoListResponseDTO> getUserTicketInfoListByUser(String username) {
		Map<String, List<UserTicket>> userTicketsGroupByCenter =
			userTicketService.getUserTicketsGroupByCenter(userService.getUserByUsername(username));

		return userTicketsGroupByCenter.keySet().stream()
			.map(key -> UserTicketInfoListResponseDTO.from(key, userTicketsGroupByCenter.get(key)))
			.collect(Collectors.toList());
	}

	public Ticket createTicket(CreateTicketRequestDTO request, String username) {
		User user = userService.getUserByUsername(username);
		Center center = centerService.getCenterByUser(user);
		return ticketService.createTicket(
			request.getTicketName(),
			LocalDate.parse(request.getTicketStartDate()),
			LocalDate.parse(request.getTicketEndDate()),
			request.getAmount(),
			request.getPrice(),
			request.getDiscountRate(),
			center
		);
	}

}
