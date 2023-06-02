package hobbyloop.backend.api.applicationservice.ticket;

import hobbyloop.backend.api.controller.ticket.dto.GetTicketListResponseDTO;
import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketApplicationService {

    private final TicketService ticketService;

    public List<GetTicketListResponseDTO> getTicketsWithRanking(String ticketType, String sortType, Pageable pageable) {
        List<Ticket> tickets = ticketService.getTicketsWithRanking(ticketType, sortType, pageable);
        return tickets.stream()
                .map(GetTicketListResponseDTO::from)
                .collect(Collectors.toList());

    }

    public List<GetTicketListResponseDTO> getTicketsWithDistance(String ticketType, double mapx, double mapy, Pageable pageable) {
        List<Ticket> tickets = ticketService.getTicketsWithDistance(ticketType, mapx, mapy, pageable);
        return tickets.stream()
                .map(GetTicketListResponseDTO::from)
                .collect(Collectors.toList());
    }

}
