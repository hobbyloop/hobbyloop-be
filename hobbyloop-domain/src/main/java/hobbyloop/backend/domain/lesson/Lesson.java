package hobbyloop.backend.domain.lesson;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.instructor.Instructor;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Lesson extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @Enumerated(EnumType.STRING)
    private LessonStatus lessonStatus;

    private int lessonCapacity;
    private int lessonEmptySpace;

    private LocalDateTime reservationDeadline;
    private LocalDateTime cancelDeadline;
    private LocalDateTime lessonDate;

}
