package hobbyloop.backend.domain.center;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.ticket.TicketType;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CenterService {
	private final CenterRepository centerRepository;
	private final UserRepository userRepository;

	public List<CenterDTO> getCentersWithRanking(String email, String ticketType, String sortType, Pageable pageable) {
		User user = userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
		return navigate(user, ticketType, sortType, pageable);
	}

	public List<CenterDTO> getCentersWithDistance(String email, String ticketType, double mapx, double mapy,
		Pageable pageable) {
		TicketType type = TicketType.of(ticketType);
		User user = userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
		return centerRepository.findCentersWithDTOOrderByDistanceDesc(type, user, mapx, mapy, pageable);
	}

	private List<CenterDTO> navigate(User user, String ticketType, String sortType, Pageable pageable) {
		TicketType type = TicketType.of(ticketType);
		CenterSortType centerSortType = CenterSortType.of(sortType);

		if (centerSortType.equals(CenterSortType.SCORE)) {
			return centerRepository.findCentersWithDTOOrderByScoreDesc(type, user, pageable);
		}
		if (centerSortType.equals(CenterSortType.AMOUNT)) {
			return centerRepository.findCentersWithDTOOrderByAmountDesc(type, user, pageable);
		}
		if (centerSortType.equals(CenterSortType.REVIEW)) {
			return centerRepository.findCentersWithDTOOrderByReviewCountDesc(type, user, pageable);
		}
		return centerRepository.findCentersWithDTOOrderByCreatedTimeDesc(type, user, pageable);
	}

	public Center getCenterById(Long centerId) {
		return centerRepository.findById(centerId).orElseThrow(EntityNotFoundException::new);
	}
}
