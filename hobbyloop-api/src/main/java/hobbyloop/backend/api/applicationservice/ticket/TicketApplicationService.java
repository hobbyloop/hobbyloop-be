package hobbyloop.backend.api.applicationservice.ticket;

import hobbyloop.backend.domain.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketApplicationService {
    private final TicketService ticketService;
}
