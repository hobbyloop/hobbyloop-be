package hobbyloop.backend.api.controller.user.dto;

import hobbyloop.backend.domain.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginResponseDTO {

    @ApiModelProperty(value = "유저 식별자", example = "1")
    private Long userId;

    @ApiModelProperty(value = "JWT token")
    private String accessToken;

    @Builder
    public LoginResponseDTO(Long userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

    public static LoginResponseDTO from(User user) {
        return LoginResponseDTO.builder()
                .userId(user.getUserId())
                .accessToken(user.getAccessToken())
                .build();
    }

    public static LoginResponseDTO from(User user,String accessToken) {
        return LoginResponseDTO.builder()
                .userId(user.getUserId())
                .accessToken(accessToken)
                .build();
    }
}
