package hobbyloop.backend.domain.ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserTicketService {

	private final UserTicketRepository userTicketRepository;

	public Map<String, List<UserTicket>> getUserTicketsGroupByCenter(User user) {
		List<UserTicket> allByUser = findAllUserTicketsByUser(user);
		Map<String, List<UserTicket>> userTicketMap = new HashMap<>();
		for (UserTicket userTicket : allByUser) {
			String centerName = userTicket.getTicket().getCenter().getCenterName();
			if (userTicketMap.containsKey(centerName)) {
				userTicketMap.get(centerName).add(userTicket);
			} else {
				List<UserTicket> userTicketsOfCenter = new ArrayList<>();
				userTicketsOfCenter.add(userTicket);
				userTicketMap.put(centerName, userTicketsOfCenter);
			}
		}
		return userTicketMap;
	}

	public List<UserTicket> findAllUserTicketsByUser(User user) {
		return userTicketRepository.findAllByUser(user);
	}

}
