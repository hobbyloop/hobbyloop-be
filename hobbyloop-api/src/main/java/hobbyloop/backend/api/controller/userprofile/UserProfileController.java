package hobbyloop.backend.api.controller.userprofile;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hobbyloop.backend.api.applicationservice.userprofile.UserProfileApplicationService;
import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.api.controller.userprofile.dto.UserProfileResponseDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"회원용 유저 정보와 관련된 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserProfileController {

	private final UserProfileApplicationService userProfileApplicationService;

	@ApiOperation(value = "사용자의 프로필 (회원가입 시 등록하는 추가 정보) 을 등록하는 요청")
	@PostMapping("/create")
	public ApiResponse<Void> createUserProfile(
		@AuthenticationPrincipal UserDetails userDetails,
		@RequestBody CreateUserProfileRequestDTO request) {

		userProfileApplicationService.createUserProfile(userDetails.getUsername(), request);
		return ApiResponse.success(HttpStatus.CREATED);
	}

	@ApiOperation(value = "회원용 유저의 프로필 상세 조회 요청")
	@GetMapping("")
	public ApiResponse<UserProfileResponseDTO> getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
		return ApiResponse.success(HttpStatus.OK,
			userProfileApplicationService.getUserProfile(userDetails.getUsername()));
	}
}
