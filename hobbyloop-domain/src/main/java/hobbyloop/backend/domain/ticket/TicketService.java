package hobbyloop.backend.domain.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getTicketsWithRanking(String ticketType, String sortType, Pageable pageable) {
        return navigate(ticketType, sortType, pageable);
    }

    public List<Ticket> getTicketsWithDistance(String ticketType, double mapx, double mapy, Pageable pageable) {
        TicketType type = TicketType.of(ticketType);
        return ticketRepository.findAllByTicketTypeAndDistance(type, mapx, mapy, pageable);
    }

    private List<Ticket> navigate(String ticketType, String sortType, Pageable pageable) {
        TicketType type = TicketType.of(ticketType);
        TicketSortType ticketSortType = TicketSortType.of(sortType);

        if (ticketSortType.equals(TicketSortType.SCORE)) {
            return ticketRepository.findAllByTicketTypeOrderByScoreDesc(type, pageable);
        }
        if (ticketSortType.equals(TicketSortType.AMOUNT)) {
            return ticketRepository.findAllByTicketTypeOrderBySalesAmountDesc(type, pageable);
        }
        return ticketRepository.findAllByTicketTypeOrderByCreatedTimeDesc(type, pageable);
    }
}
