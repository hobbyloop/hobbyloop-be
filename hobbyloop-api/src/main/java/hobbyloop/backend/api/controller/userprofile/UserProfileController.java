package hobbyloop.backend.api.controller.userprofile;

import hobbyloop.backend.api.applicationservice.userprofile.UserProfileApplicationService;
import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserProfileController {

    private final UserProfileApplicationService userProfileApplicationService;

    @ApiOperation(value = "사용자의 프로필 (회원가입 시 등록하는 추가 정보) 을 등록하는 요청")
    @PostMapping("/create")
    public ApiResponse<Void> createUserProfile(
            @RequestBody CreateUserProfileRequestDTO request) {

        userProfileApplicationService.createUserProfile(request);
        return ApiResponse.success(HttpStatus.CREATED);
    }
}
