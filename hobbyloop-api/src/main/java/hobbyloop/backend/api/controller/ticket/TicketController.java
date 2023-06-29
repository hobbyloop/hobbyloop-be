package hobbyloop.backend.api.controller.ticket;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hobbyloop.backend.api.applicationservice.ticket.TicketApplicationService;
import hobbyloop.backend.api.controller.ticket.dto.TicketInfoResponseDTO;
import hobbyloop.backend.api.controller.ticket.dto.UserTicketInfoListResponseDTO;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"이용권 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private final TicketApplicationService ticketApplicationService;

	@ApiOperation(value = "자신의 이용권 리스트 조회", notes = "회원용 유저가 자신의 이용권 리스트를 조회하는 요청입니다.")
	@GetMapping("/user/list")
	public ApiResponse<List<UserTicketInfoListResponseDTO>> getUserTicketInfoList(
		@ApiIgnore @AuthenticationPrincipal OAuth2UserDetails userDetails
	) {
		return ApiResponse.success(HttpStatus.OK,
			ticketApplicationService.getUserTicketInfoListByUser(userDetails.getUsername()));
	}

	@ApiOperation(value = "센터 내 이용권 리스트 조회", notes = "회원용 유저가 센터 내 이용권 목록 조회하는 요청입니다.")
	@GetMapping("/list/{centerId}")
	public ApiResponse<List<TicketInfoResponseDTO>> getTicketInfoListByCenter(
		@ApiIgnore @AuthenticationPrincipal OAuth2UserDetails userDetails, @PathVariable Long centerId
	) {
		return ApiResponse.success(HttpStatus.OK,
			ticketApplicationService.getTicketInfoListOfCenter(centerId, userDetails.getUsername()));
	}
}
