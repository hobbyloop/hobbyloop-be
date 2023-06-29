package hobbyloop.backend.domain.ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hobbyloop.backend.domain.center.Center;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	List<Ticket> findAllByCenter(Center center);
}
