package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.domain.ticket.UserTicket;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTicketInfoDTO {
    private String centerName;
    private int remainingCounts;
    private LocalDate endDate;

    public static UserTicketInfoDTO from(UserTicket userTicket) {
        return UserTicketInfoDTO.builder()
                .centerName(userTicket.getCenter().getName())
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
