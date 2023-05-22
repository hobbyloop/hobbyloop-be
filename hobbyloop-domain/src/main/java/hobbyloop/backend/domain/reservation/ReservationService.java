package hobbyloop.backend.domain.reservation;

import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Optional<Reservation> findEarliestReservationByUser(User user) {
        return reservationRepository.findTopByUserOrderByLessonDate(user);
    }
}
