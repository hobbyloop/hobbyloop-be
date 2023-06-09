package hobbyloop.backend.api.applicationservice.center;

import static hobbyloop.backend.api.controller.util.Constant.*;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hobbyloop.backend.api.controller.center.dto.CenterListResponseDTO;
import hobbyloop.backend.api.controller.center.dto.CenterTypeDTO;
import hobbyloop.backend.api.controller.center.dto.CreateCenterRequestDTO;
import hobbyloop.backend.api.controller.center.dto.RegisterFacilityRequestDTO;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.center.CenterDTO;
import hobbyloop.backend.domain.center.CenterService;
import hobbyloop.backend.domain.user.Role;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CenterApplicationService {

	private final CenterService centerService;

	private final UserService userService;

	public void createCenter(String username, CreateCenterRequestDTO request) {
		User user = userService.getUserByUsername(username);
		centerService.createCenter(
			request.getRepresentativeName(),
			request.getPhoneNumber(),
			request.getAddress(),
			request.getBusinessNumber(),
			request.getAccountNumber(),
			request.getLongitude(),
			request.getLatitude(),
			user
		);
		userService.appendUserRole(user, Role.CENTER);
	}

	public void registerFacility(String username, RegisterFacilityRequestDTO request) {
		User user = userService.getUserByUsername(username);
		Center center = centerService.getCenterByUser(user);
		centerService.registerFacility(
			request.getFacilityName(),
			request.getAddress(),
			request.getFacilityIntroduction(),
			request.getPhoneNumber(),
			LocalTime.parse(request.getOperatingStartTime()),
			LocalTime.parse(request.getOperatingEndTime()),
			center
		);
	}

	public List<CenterListResponseDTO> getCentersWithRanking(String email, String ticketType, String sortType,
		Pageable pageable) {
		List<CenterDTO> centers = centerService.getCentersWithRanking(email, ticketType, sortType, pageable);
		return centers.stream()
			.map(CenterListResponseDTO::from)
			.collect(Collectors.toList());
	}

	public List<CenterListResponseDTO> getCentersWithDistance(String email, String ticketType, double mapx, double mapy,
		Pageable pageable) {
		List<CenterDTO> centers = centerService.getCentersWithDistance(email, ticketType, mapx, mapy, pageable);
		return centers.stream()
			.map(CenterListResponseDTO::from)
			.collect(Collectors.toList());
	}

	public List<CenterTypeDTO> getCenterTypeList() {
		return CENTER_LOGO_AND_LIST.stream()
			.map(CenterTypeDTO::new)
			.collect(Collectors.toList());
	}
}
