package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserStatus;
import hobbyloop.backend.domain.userProfile.Gender;
import hobbyloop.backend.domain.userProfile.UserProfile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUserProfileRequestDTO {

    private Long userId;
    private UserStatus userStatus;
    private String name;
    private String nickname;
    private String gender;

    private int point;
    private String account;
    private LocalDate infoAgreement;
    private LocalDate locationAgreement;

    public static UserProfile toUserProfile(CreateUserProfileRequestDTO createUserProfileRequestDTO, User user) {
        return UserProfile.builder()
                .user(user)
                .userStatus(createUserProfileRequestDTO.userStatus)
                .name(createUserProfileRequestDTO.name)
                .nickname(createUserProfileRequestDTO.nickname)
                .gender(Gender.of(createUserProfileRequestDTO.gender))
                .build();
    }

}
