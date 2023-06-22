package hobbyloop.backend.api.controller.ticket;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hobbyloop.backend.api.applicationservice.ticket.TicketApplicationService;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {"이용권 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private final TicketApplicationService ticketApplicationService;

	@GetMapping("/list")
	public ApiResponse<List<UserTicketInfoListResponseDTO>> getUserTicketInfoList(
		@ApiIgnore @AuthenticationPrincipal OAuth2UserDetails userDetails
	) {
		return ApiResponse.success(HttpStatus.OK,
			ticketApplicationService.getUserTicketInfoListByUser(userDetails.getUsername()));
	}
}
