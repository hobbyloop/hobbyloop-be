package hobbyloop.backend.api.controller.instructor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hobbyloop.backend.domain.instructor.Instructor;
import hobbyloop.backend.domain.lesson.LessonStatus;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InstructorInfoResponseDTO {
    private String instructorName;
    private String instructorRepImageUrl;
    private List<LessonInfoResponseDTO> lessons;

    public static InstructorInfoResponseDTO from(Instructor instructor) {
        return InstructorInfoResponseDTO.builder()
                .instructorName(instructor.getInstructorName())
                .instructorRepImageUrl(instructor.getInstructorRepImageUrl())
                .lessons(instructor.getLessons().stream()
                        .filter(lesson -> !lesson.getLessonStatus().equals(LessonStatus.OUTDATED))
                        .map(LessonInfoResponseDTO::from).collect(Collectors.toList()))
                .build();
    }
}
