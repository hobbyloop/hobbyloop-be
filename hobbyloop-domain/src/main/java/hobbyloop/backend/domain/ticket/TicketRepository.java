package hobbyloop.backend.domain.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findTop50ByTicketTypeOrderByCreatedTimeDesc(TicketType ticketType);
    List<Ticket> findTop50ByTicketTypeOrderBySalesAmountDesc(TicketType ticketType);
    List<Ticket> findTop50ByTicketTypeOrderByScoreDesc(TicketType ticketType);

}
