package hobbyloop.backend.api.controller.reservation.dto;

import hobbyloop.backend.domain.reservation.Reservation;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ReservationResponseDTO {

    @ApiModelProperty(name = "업체명", example = "에이블짐 창신점")
    private String centerName;

    @ApiModelProperty(name = "수업 시작", example = "2023-05-24 10:00")
    private LocalDateTime lessonStart;

    @ApiModelProperty(name = "수업 종료", example = "2023-05-24 20:00")
    private LocalDateTime lessonEnd;

    @ApiModelProperty(name = "정원", example = "10")
    private int lessonCapacity;

    @ApiModelProperty(name = "남은 자리", example = "9")
    private int lessonEmptySpace;

    public static ReservationResponseDTO from(Reservation reservation) {
        return ReservationResponseDTO.builder()
                .centerName(reservation.getLesson().getCenter().getCenterName())
                .lessonStart(reservation.getLesson().getLessonStartDateTime())
                .lessonEnd(reservation.getLesson().getLessonEndDateTime())
                .lessonCapacity(reservation.getLesson().getLessonCapacity())
                .lessonEmptySpace(reservation.getLesson().getLessonEmptySpace())
                .build();
    }
}
