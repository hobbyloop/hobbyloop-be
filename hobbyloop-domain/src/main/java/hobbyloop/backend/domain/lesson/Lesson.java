package hobbyloop.backend.domain.lesson;

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
import hobbyloop.backend.domain.instructor.DifficultyType;
import hobbyloop.backend.domain.instructor.Instructor;
import lombok.Getter;

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

	@Enumerated(value = EnumType.STRING)
	private DifficultyType difficultyType;

	private int lessonCapacity;

	private int lessonEmptySpace;

	private LocalDateTime reservationDeadline;

	private LocalDateTime cancelDeadline;

	private LocalDateTime lessonStartDateTime;

	private LocalDateTime lessonEndDateTime;

}
