package hobbyloop.backend.domain.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

    private static final String SORT_TYPE_RECENT = "recently";
    private static final String SORT_TYPE_SALES_AMOUNT = "amount";
    private static final String SORT_TYPE_SCORE = "score";

    private final TicketRepository ticketRepository;

    public List<Ticket> getTicketsWithRanking(String ticketType, String sortType) {
        return navigate(ticketType, sortType);
    }

    private List<Ticket> navigate(String ticketType, String sortType) {
        TicketType type = TicketType.of(ticketType);

        if (sortType.equals(SORT_TYPE_SCORE)) {
            return ticketRepository.findTop50ByTicketTypeOrderByScoreDesc(type);
        }
        if (sortType.equals(SORT_TYPE_SALES_AMOUNT)) {
            return ticketRepository.findTop50ByTicketTypeOrderBySalesAmountDesc(type);
        }
        return ticketRepository.findTop50ByTicketTypeOrderByCreatedTimeDesc(type);

    }
}
