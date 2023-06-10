package hobbyloop.backend.domain.reservation;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hobbyloop.backend.domain.user.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@EntityGraph(attributePaths = {"lesson", "lesson.center"})
	Optional<Reservation> findFirstByUserAndLessonStartDateTimeAfterOrderByLessonStartDateTimeAsc(User user,
		LocalDateTime localDateTime);
}
