package hobbyloop.backend.domain.ticket;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hobbyloop.backend.domain.user.User;

public interface UserTicketRepository extends JpaRepository<UserTicket, Long> {

	@EntityGraph(attributePaths = {"ticket", "ticket.center"})
	List<UserTicket> findAllByUser(User user);
}
