package hobbyloop.backend.api.controller.userprofile;

import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserProfileController {

    private final UserProfileApplicationService userProfileApplicationService;
    @PostMapping("/create")
    public ApiResponse<Void> createUserProfile(
            @RequestBody CreateUserProfileRequestDTO request) {

        userProfileApplicationService.createUserProfile(request);
        return ApiResponse.success(HttpStatus.OK);
    }
}
