package hobbyloop.backend.api.applicationservice.userprofile;

import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.api.controller.userprofile.dto.UserProfileResponseDTO;
import hobbyloop.backend.domain.reservation.Reservation;
import hobbyloop.backend.domain.reservation.ReservationService;
import hobbyloop.backend.domain.ticket.UserTicket;
import hobbyloop.backend.domain.ticket.UserTicketService;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import hobbyloop.backend.domain.userProfile.UserProfile;
import hobbyloop.backend.domain.userProfile.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileApplicationService {

    private final UserProfileService userProfileService;
    private final UserService userService;
    private final ReservationService reservationService;
    private final UserTicketService userTicketService;

    public void createUserProfile(CreateUserProfileRequestDTO request) {
        userProfileService.createUserProfile(
                CreateUserProfileRequestDTO.toUserProfile(request, userService.getUserById(request.getUserId())));
        userService.updateUserRole(request.getUserId());
    }

    public UserProfileResponseDTO getUserProfile(Long userId) {
        User user = userService.getUserById(userId);
        UserProfile userProfile = userProfileService.findUserProfileByUser(user);
        Optional<Reservation> reservation = reservationService.findEarliestReservationByUser(user);
        List<UserTicket> userTickets = userTicketService.findAllUserTicketsByUser(user);

        if (reservation.isEmpty()) {
            return UserProfileResponseDTO.from(userTickets, userProfile);
        }
        return UserProfileResponseDTO.from(reservation.get(), userTickets, userProfile);
    }
}
