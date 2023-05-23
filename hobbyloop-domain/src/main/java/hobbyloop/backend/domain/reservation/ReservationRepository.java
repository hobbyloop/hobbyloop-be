package hobbyloop.backend.domain.reservation;

import hobbyloop.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findTopByUserOrderByLessonDate(User user);
}
