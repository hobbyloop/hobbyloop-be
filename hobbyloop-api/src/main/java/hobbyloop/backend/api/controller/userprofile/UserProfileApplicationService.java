package hobbyloop.backend.api.controller.userprofile;

import hobbyloop.backend.api.controller.userprofile.dto.CreateUserProfileRequestDTO;
import hobbyloop.backend.domain.user.UserService;
import hobbyloop.backend.domain.userProfile.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileApplicationService {

    private final UserProfileService userProfileService;
    private final UserService userService;

    public void createUserProfile(CreateUserProfileRequestDTO request) {
        userProfileService.createUserProfile(
                CreateUserProfileRequestDTO.toUserProfile(request, userService.getUserById(request.getUserId())));
        userService.updateUserRole(request.getUserId());
    }
}
