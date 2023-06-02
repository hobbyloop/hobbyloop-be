package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.domain.ticket.UserTicket;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTicketInfoDTO {

    @ApiModelProperty(name = "업체명", example = "에이블짐 창신점")
    private String centerName;

    @ApiModelProperty(name = "이용권의 남은 횟수", example = "9")
    private int remainingCounts;

    @ApiModelProperty(name = "종료일", example = "2023-05-24")
    private LocalDate endDate;

    public static UserTicketInfoDTO from(UserTicket userTicket) {
        return UserTicketInfoDTO.builder()
                .centerName(userTicket.getCenter().getCenterName())
                .remainingCounts(userTicket.getRemainingCounts())
                .endDate(userTicket.getEndDate())
                .build();
    }

    public static List<UserTicketInfoDTO> from(List<UserTicket> userTickets) {
        return userTickets.stream()
                .map(UserTicketInfoDTO::from)
                .collect(Collectors.toList());
    }
}
