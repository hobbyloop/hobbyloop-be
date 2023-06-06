package hobbyloop.backend.domain.ticket;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

	private final TicketRepository ticketRepository;
}
