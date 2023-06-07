package hobbyloop.backend.api.controller.userprofile.dto;

import java.time.LocalDate;

import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserStatus;
import hobbyloop.backend.domain.userProfile.Gender;
import hobbyloop.backend.domain.userProfile.UserProfile;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUserProfileRequestDTO {
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

	public static UserProfile toUserProfile(CreateUserProfileRequestDTO createUserProfileRequestDTO, User user) {
		return UserProfile.builder()
			.user(user)
			.userStatus(UserStatus.ACTIVE)
			.name(createUserProfileRequestDTO.name)
			.nickname(createUserProfileRequestDTO.nickname)
			.gender(Gender.of(createUserProfileRequestDTO.gender))
			.birth((createUserProfileRequestDTO.birth))
			.phoneNum(createUserProfileRequestDTO.phoneNum)
			.build();
	}
}
