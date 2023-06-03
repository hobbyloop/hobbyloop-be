package hobbyloop.backend.api.controller.instructor.dto;

import hobbyloop.backend.domain.lesson.Lesson;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LessonInfoResponseDTO {
    private LocalDateTime start;
    private LocalDateTime end;
    private int lessonCapacity;
    private int lessonEmptySpace;
    private String difficulty;

    public static LessonInfoResponseDTO from(Lesson lesson) {
        return LessonInfoResponseDTO.builder()
                .start(lesson.getLessonStartDateTime())
                .end(lesson.getLessonEndDateTime())
                .lessonCapacity(lesson.getLessonCapacity())
                .lessonEmptySpace(lesson.getLessonEmptySpace())
                .difficulty(lesson.getDifficultyType().getDifficulty())
                .build();
    }
}
