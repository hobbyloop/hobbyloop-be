package hobbyloop.backend.api.infra.global.oauth2.strategy;

import hobbyloop.backend.domain.user.SocialType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Slf4j
public class KakaoLoadStrategy extends SocialLoadStrategy {

    private Map<String, Object> properties;

    protected Map<String, Object> sendRequestToSocialSite(HttpEntity request) {
        try {
            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(SocialType.KAKAO.getUserInfoUrl(),// -> /v2/user/me
                    SocialType.KAKAO.getMethod(),
                    request,
                    RESPONSE_TYPE);
            return response.getBody();//카카오는 id를 PK로 사용

        } catch (Exception e) {
            log.error("AccessToken을 사용하여 KAKAO 유저정보를 받아오던 중 예외가 발생했습니다 {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public String getSocialPk(Map<String, Object> response) {
        return response.get("id").toString();
    }

    @Override
    public String getEmail(Map<String, Object> response) {
        properties = (Map<String, Object>) response.get("kakao_account");
        return properties.get("email").toString();
    }
}
