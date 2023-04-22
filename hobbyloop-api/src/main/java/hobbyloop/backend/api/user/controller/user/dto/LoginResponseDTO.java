package hobbyloop.backend.api.user.controller.user.dto;

import lombok.Getter;

@Getter
public class LoginResponseDTO {

    private Long userId;
    private String accessToken;

    public LoginResponseDTO(Long userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }
}
