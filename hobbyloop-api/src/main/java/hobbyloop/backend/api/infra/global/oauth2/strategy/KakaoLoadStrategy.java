package hobbyloop.backend.api.infra.global.oauth2.strategy;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import hobbyloop.backend.domain.user.SocialType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoLoadStrategy extends SocialLoadStrategy {

	protected Map<String, Object> sendRequestToSocialSite(HttpEntity request) {
		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(SocialType.KAKAO.getUserInfoUrl(),
				SocialType.KAKAO.getMethod(),
				request,
				RESPONSE_TYPE);
			return response.getBody();

		} catch (Exception e) {
			log.error("AccessToken을 사용하여 KAKAO 유저정보를 받아오던 중 예외가 발생했습니다 {}", e.toString());
			throw e;
		}
	}

	@Override
	public String getSocialPk(Map<String, Object> response) {
		return response.get("id").toString();
	}

	@Override
	public String getEmail(Map<String, Object> response) {
		Map<String, Object> properties = (Map<String, Object>)response.get("kakao_account");
		return properties.get("email").toString();
	}
}
