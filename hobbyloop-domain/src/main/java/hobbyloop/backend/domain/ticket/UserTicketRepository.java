package hobbyloop.backend.domain.ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hobbyloop.backend.domain.user.User;

public interface UserTicketRepository extends JpaRepository<UserTicket, Long> {
	List<UserTicket> findAllByUser(User user);
}
