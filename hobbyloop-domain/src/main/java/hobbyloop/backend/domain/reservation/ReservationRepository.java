package hobbyloop.backend.domain.reservation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hobbyloop.backend.domain.user.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Optional<Reservation> findTopByUserOrderByLessonDate(User user);
}
