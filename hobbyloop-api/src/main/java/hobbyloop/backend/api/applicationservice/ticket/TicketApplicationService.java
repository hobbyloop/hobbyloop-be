package hobbyloop.backend.api.applicationservice.ticket;

import org.springframework.stereotype.Service;

import hobbyloop.backend.domain.ticket.TicketService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketApplicationService {
	private final TicketService ticketService;
}
