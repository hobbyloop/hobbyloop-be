package hobbyloop.backend.api.controller.user;

import hobbyloop.backend.api.applicationservice.user.UserApplicationService;
import hobbyloop.backend.api.controller.user.dto.LoginResponseDTO;
import hobbyloop.backend.api.infra.global.jwt.service.JwtService;
import hobbyloop.backend.api.infra.util.ApiResponse;
import hobbyloop.backend.domain.user.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;
    private final JwtService jwtService;

    @ApiOperation(value = "소셜 로그인이 완료되면 redirect 되는 요청")
    @GetMapping("")
    public ApiResponse<LoginResponseDTO> loginSuccessRequest(@RequestParam String authorization) throws Exception {

        User user = userApplicationService.findByEmail(
                jwtService.extractEmail(authorization).
                        orElseThrow(() -> new Exception("토큰에서 이메일 추출에 실패하였습니다."))).orElseThrow(EntityNotFoundException::new);

        if (user.getAccessToken() == null) {
            return ApiResponse.success(HttpStatus.OK, LoginResponseDTO.from(user,authorization));
        }
        user.updateAccessToken(authorization);
        return ApiResponse.success(HttpStatus.OK, LoginResponseDTO.from(user));
    }
}
