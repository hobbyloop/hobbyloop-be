package hobbyloop.backend.domain.ticket;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByTicketTypeOrderByCreatedTimeDesc(TicketType ticketType, Pageable pageable);

    List<Ticket> findAllByTicketTypeOrderBySalesAmountDesc(TicketType ticketType, Pageable pageable);

    List<Ticket> findAllByTicketTypeOrderByScoreDesc(TicketType ticketType, Pageable pageable);

}
