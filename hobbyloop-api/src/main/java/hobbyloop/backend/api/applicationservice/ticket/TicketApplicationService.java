package hobbyloop.backend.api.applicationservice.ticket;

import hobbyloop.backend.api.controller.ticket.dto.GetTicketListResponseDTO;
import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketApplicationService {

    private final TicketService ticketService;

    public List<GetTicketListResponseDTO> getTicketsWithRanking(String ticketType, String sortType) {
        List<Ticket> tickets = ticketService.getTicketsWithRanking(ticketType, sortType);
        return tickets.stream()
                .map(GetTicketListResponseDTO::from)
                .collect(Collectors.toList());

    }
}
