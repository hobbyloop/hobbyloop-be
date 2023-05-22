package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.api.controller.reservation.dto.GetReservationRespondDTO;
import hobbyloop.backend.domain.reservation.Reservation;
import hobbyloop.backend.domain.ticket.UserTicket;
import hobbyloop.backend.domain.userProfile.UserProfile;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetUserProfileRespondDTO {
    private GetReservationRespondDTO reservationInfo;
    private List<GetUserTicketInfo> userTicketInfos;
    private int chargedPoint;
    private int givenPoint;

    public static GetUserProfileRespondDTO from(
            Reservation reservation,
            List<UserTicket> userTickets,
            UserProfile userProfile
    ) {
        return GetUserProfileRespondDTO.builder()
                .reservationInfo(GetReservationRespondDTO.from(reservation))
                .userTicketInfos(GetUserTicketInfo.from(userTickets))
                .chargedPoint(userProfile.getChargedPoint())
                .givenPoint(userProfile.getGivenPoint())
                .build();
    }

    public static GetUserProfileRespondDTO from(
            List<UserTicket> userTickets,
            UserProfile userProfile
    ) {
        return GetUserProfileRespondDTO.builder()
                .userTicketInfos(GetUserTicketInfo.from(userTickets))
                .chargedPoint(userProfile.getChargedPoint())
                .givenPoint(userProfile.getGivenPoint())
                .build();
    }

}
