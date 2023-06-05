package hobbyloop.backend.domain.ticket;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserTicketService {

	private final UserTicketRepository userTicketRepository;

	public List<UserTicket> findAllUserTicketsByUser(User user) {
		return userTicketRepository.findAllByUser(user);
	}
}
