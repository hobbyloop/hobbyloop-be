package hobbyloop.backend.api.infra.global.oauth2.strategy;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import hobbyloop.backend.domain.user.SocialType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleLoadStrategy extends SocialLoadStrategy {

	protected Map<String, Object> sendRequestToSocialSite(HttpEntity request) {
		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(SocialType.GOOGLE.getUserInfoUrl(),
				SocialType.GOOGLE.getMethod(),
				request,
				RESPONSE_TYPE);
			return response.getBody();//구글은 sub를 PK로 사용
		} catch (Exception e) {
			log.error("AccessToken을 사용하여 GOOGLE 유저정보를 받아오던 중 예외가 발생했습니다 {}", e.toString());
			throw e;
		}
	}

	@Override
	public String getSocialPk(Map<String, Object> response) {
		return response.get("sub").toString();
	}

	@Override
	public String getEmail(Map<String, Object> response) {
		return response.get("email").toString();
	}
}
