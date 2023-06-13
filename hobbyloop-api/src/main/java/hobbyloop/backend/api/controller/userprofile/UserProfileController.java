package hobbyloop.backend.api.controller.userprofile;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hobbyloop.backend.api.applicationservice.userprofile.UserProfileApplicationService;
import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.api.controller.userprofile.dto.UserProfileResponseDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"회원용 유저 정보와 관련된 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserProfileController {

	private final UserProfileApplicationService userProfileApplicationService;

	@ApiOperation(value = "프로필 생성", notes = "사용자의 프로필 (회원가입 시 등록하는 추가 정보) 을 등록하는 요청")
	@PostMapping("/create")
	public ApiResponse<Void> createUserProfile(@ApiIgnore @AuthenticationPrincipal UserDetails userDetails,
		@RequestBody CreateUserProfileRequestDTO request) {

		userProfileApplicationService.createUserProfile(userDetails.getUsername(), request);
		return ApiResponse.success(HttpStatus.CREATED);
	}

	@ApiOperation(value = "프로필 상세 조회", notes = "회원용 유저의 프로필 상세 조회 요청")
	@GetMapping("")
	public ApiResponse<UserProfileResponseDTO> getUserProfile(
		@ApiIgnore @AuthenticationPrincipal UserDetails userDetails) {
		return ApiResponse.success(HttpStatus.OK,
			userProfileApplicationService.getUserProfile(userDetails.getUsername()));
	}

	@ApiOperation(value = "기본 검색 카테고리 설정 api / 최초 설정 이후 변경 시에도 동일하게 사용")
	@ApiImplicitParam(name = "ticketType", value = "검색 카테고리", dataTypeClass = String.class)
	@PatchMapping("/update/ticketType")
	public ApiResponse<Void> changeDefaultTicketType(@ApiIgnore @AuthenticationPrincipal UserDetails userDetails,
		@RequestParam String ticketType) {

		userProfileApplicationService.changeUserProfile(userDetails.getUsername(), ticketType);
		return ApiResponse.success(HttpStatus.OK);
	}
}
