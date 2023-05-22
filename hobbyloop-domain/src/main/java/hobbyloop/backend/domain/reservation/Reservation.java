package hobbyloop.backend.domain.reservation;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.lesson.Lesson;
import hobbyloop.backend.domain.user.User;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

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
