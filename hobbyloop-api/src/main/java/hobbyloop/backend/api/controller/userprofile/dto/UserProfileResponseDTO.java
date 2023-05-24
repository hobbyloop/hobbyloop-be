package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.api.controller.reservation.dto.ReservationResponseDTO;
import hobbyloop.backend.domain.reservation.Reservation;
import hobbyloop.backend.domain.ticket.UserTicket;
import hobbyloop.backend.domain.userProfile.UserProfile;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfileResponseDTO {
    private ReservationResponseDTO reservationInfo;
    private List<UserTicketInfoDTO> userTicketInfoList;
    private int chargedPoint;
    private int givenPoint;

    public static UserProfileResponseDTO from(
            Reservation reservation,
            List<UserTicket> userTickets,
            UserProfile userProfile
    ) {
        return UserProfileResponseDTO.builder()
                .reservationInfo(ReservationResponseDTO.from(reservation))
                .userTicketInfoList(UserTicketInfoDTO.from(userTickets))
                .chargedPoint(userProfile.getChargedPoint())
                .givenPoint(userProfile.getGivenPoint())
                .build();
    }

    public static UserProfileResponseDTO from(
            List<UserTicket> userTickets,
            UserProfile userProfile
    ) {
        return UserProfileResponseDTO.builder()
                .userTicketInfoList(UserTicketInfoDTO.from(userTickets))
                .chargedPoint(userProfile.getChargedPoint())
                .givenPoint(userProfile.getGivenPoint())
                .build();
    }
}
