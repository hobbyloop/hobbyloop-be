package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.api.controller.reservation.dto.ReservationResponseDTO;
import hobbyloop.backend.domain.reservation.Reservation;
import hobbyloop.backend.domain.ticket.UserTicket;
import hobbyloop.backend.domain.userProfile.UserProfile;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfileResponseDTO {
    private ReservationResponseDTO reservationInfo;
    private List<UserTicketInfoDTO> userTicketInfoList;

    @ApiModelProperty(name = "충전 포인트", example = "50000")
    private int chargedPoint;

    @ApiModelProperty(name = "지급 포인트", example = "50")
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
