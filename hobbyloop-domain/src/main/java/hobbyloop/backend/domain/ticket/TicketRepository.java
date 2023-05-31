package hobbyloop.backend.domain.ticket;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @EntityGraph(value = "Ticket.center")
    List<Ticket> findAllByTicketTypeOrderByCreatedTimeDesc(TicketType ticketType, Pageable pageable);

    @EntityGraph(value = "Ticket.center")
    List<Ticket> findAllByTicketTypeOrderBySalesAmountDesc(TicketType ticketType, Pageable pageable);

    @EntityGraph(value = "Ticket.center")
    List<Ticket> findAllByTicketTypeOrderByScoreDesc(TicketType ticketType, Pageable pageable);

    @EntityGraph(value = "Ticket.center")
    @Query(value = ("SELECT t " +
            "FROM Ticket t " +
            "JOIN Center c ON c.centerId = t.center.centerId " +
            "WHERE t.ticketType = ?1 " +
            "ORDER BY FUNCTION('ST_DISTANCE', POINT(c.mapx, c.mapy), POINT(?2, ?3)) ASC, t.score DESC"))
    List<Ticket> findAllByTicketTypeAndDistance(TicketType ticketType,double mapx, double mapy, Pageable pageable);
}
