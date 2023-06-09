package hobbyloop.backend.api.applicationservice.userprofile;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.api.controller.userprofile.dto.UserProfileResponseDTO;
import hobbyloop.backend.domain.reservation.Reservation;
import hobbyloop.backend.domain.reservation.ReservationService;
import hobbyloop.backend.domain.ticket.TicketType;
import hobbyloop.backend.domain.ticket.UserTicket;
import hobbyloop.backend.domain.ticket.UserTicketService;
import hobbyloop.backend.domain.user.Role;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import hobbyloop.backend.domain.userProfile.UserProfile;
import hobbyloop.backend.domain.userProfile.UserProfileService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileApplicationService {

	private final UserProfileService userProfileService;
	private final UserService userService;
	private final ReservationService reservationService;
	private final UserTicketService userTicketService;

	public void createUserProfile(String username, CreateUserProfileRequestDTO request) {
		User user = userService.getUserByUsername(username);
		userProfileService.createUserProfile(
			CreateUserProfileRequestDTO.toUserProfile(request, user));
		userService.appendUserRole(user, Role.USER);
	}

	public UserProfileResponseDTO getUserProfile(String username) {
		User user = userService.getUserByUsername(username);
		UserProfile userProfile = userProfileService.findUserProfileByUser(user);
		Optional<Reservation> reservation = reservationService.findEarliestReservationByUser(user);
		List<UserTicket> userTickets = userTicketService.findAllUserTicketsByUser(user);

		if (reservation.isEmpty()) {
			return UserProfileResponseDTO.from(userTickets, userProfile);
		}
		return UserProfileResponseDTO.from(reservation.get(), userTickets, userProfile);
	}

	public void changeUserProfile(String username, String ticketType) {
		User user = userService.getUserByUsername(username);
		UserProfile userProfile = userProfileService.findUserProfileByUser(user);
		userProfile.changeDefaultTicketType(TicketType.of(ticketType));
		userProfileService.updateUserProfile(userProfile);
	}
}
