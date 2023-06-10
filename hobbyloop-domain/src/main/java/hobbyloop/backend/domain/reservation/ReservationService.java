package hobbyloop.backend.domain.reservation;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {

	private final ReservationRepository reservationRepository;

	public Optional<Reservation> findEarliestReservationByUser(User user) {
		LocalDateTime now = LocalDateTime.now();
		return reservationRepository.findFirstByUserAndLessonStartDateTimeAfterOrderByLessonStartDateTimeAsc(user, now);
	}
}
