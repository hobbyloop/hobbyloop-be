package hobbyloop.backend.domain.reservation;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.lesson.Lesson;
import hobbyloop.backend.domain.user.User;
import lombok.Getter;

@Entity
@Getter
public class Reservation extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;

	@ManyToOne
	@JoinColumn(name = "lessonId")
	private Lesson lesson;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Enumerated(EnumType.STRING)
	private ReservationStatus reservationStatus;

	private LocalDate lessonDate;
}
