package hobbyloop.backend.domain.reservation;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;

@Entity
public class CounselingReservation extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long counselingReservationId;

	@ManyToOne
	@JoinColumn(name = "centerId")
	private Center center;

	@Enumerated(EnumType.STRING)
	private ReservationStatus reservationStatus;

	private LocalDateTime counselingTime;
}
