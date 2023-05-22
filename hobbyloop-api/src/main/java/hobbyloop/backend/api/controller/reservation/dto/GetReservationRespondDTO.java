package hobbyloop.backend.api.controller.reservation.dto;

import hobbyloop.backend.domain.reservation.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class GetReservationRespondDTO {
    private String centerName;
    private LocalDate lessonDay;
    private int lessonCapacity;
    private int lessonEmptySpace;

    public static GetReservationRespondDTO from(Reservation reservation) {
        return GetReservationRespondDTO.builder()
                .centerName(reservation.getLesson().getCenter().getName())
                .lessonDay(reservation.getLesson().getLessonDate().toLocalDate())
                .lessonCapacity(reservation.getLesson().getLessonCapacity())
                .lessonEmptySpace(reservation.getLesson().getLessonEmptySpace())
                .build();
    }
}
