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
public class GetUserTicketInfo {
    private String centerName;
    private int remainingCounts;
    private LocalDate endDate;

    public static GetUserTicketInfo from(UserTicket userTicket) {
        return GetUserTicketInfo.builder()
                .centerName(userTicket.getCenter().getName())
                .remainingCounts(userTicket.getRemainingCounts())
                .endDate(userTicket.getEndDate())
                .build();
    }

    public static List<GetUserTicketInfo> from(List<UserTicket> userTickets) {
        return userTickets.stream()
                .map(GetUserTicketInfo::from)
                .collect(Collectors.toList());
    }
}
