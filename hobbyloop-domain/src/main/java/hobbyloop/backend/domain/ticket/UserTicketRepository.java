package hobbyloop.backend.domain.ticket;

import hobbyloop.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTicketRepository extends JpaRepository<UserTicket, Long> {

    List<UserTicket> findAllByUser(User user);
}
