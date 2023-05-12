package hobbyloop.backend.api.controller.userprofile.dto;

import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserStatus;
import hobbyloop.backend.domain.userProfile.Gender;
import hobbyloop.backend.domain.userProfile.UserProfile;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUserProfileRequestDTO {

    @ApiModelProperty(value = "유저 식별자", example = "1")
    private Long userId;

    @ApiModelProperty(value = "유저의 이름", example = "임종호")
    private String name;

    @ApiModelProperty(value = "유저의 별명", example = "jongho")
    private String nickname;

    @ApiModelProperty(value = "성별", example = "남자")
    private String gender;

    @ApiModelProperty(value = "생일", example = "1998-07-03")
    private LocalDate birth;

    @ApiModelProperty(value = "전화번호")
    private String phoneNum;

    @ApiModelProperty(value = "개인정보 활용 동의 날짜", example = "2023-05-10")
    private LocalDate infoAgreement;

    @ApiModelProperty(value = "위치정보 활용 동의 날짜", example = "2023-05-10")
    private LocalDate locationAgreement;

    public static UserProfile toUserProfile(CreateUserProfileRequestDTO createUserProfileRequestDTO, User user) {
        return UserProfile.builder()
                .user(user)
                .userStatus(UserStatus.ACTIVE)
                .name(createUserProfileRequestDTO.name)
                .nickname(createUserProfileRequestDTO.nickname)
                .gender(Gender.of(createUserProfileRequestDTO.gender))
                .birth((createUserProfileRequestDTO.birth))
                .phoneNum(createUserProfileRequestDTO.phoneNum)
                .infoAgreement(createUserProfileRequestDTO.infoAgreement)
                .locationAgreement(createUserProfileRequestDTO.locationAgreement)
                .build();
    }
}
