package hobbyloop.backend.domain.center;

import hobbyloop.backend.domain.ticket.TicketType;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CenterService {
    private final CenterRepository centerRepository;
    private final UserRepository userRepository;

    public List<CenterDTO> getCentersWithRanking(Long userId, String ticketType, String sortType, Pageable pageable) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        return navigate(user, ticketType, sortType, pageable);
    }

    public List<CenterDTO> getCentersWithDistance(Long userId, String ticketType, double mapx, double mapy, Pageable pageable) {
        TicketType type = TicketType.of(ticketType);
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
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
