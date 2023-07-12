package hobbyloop.backend.api.infra.global.oauth2.strategy;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import hobbyloop.backend.domain.exception.token.social.NaverAccessTokenException;
import hobbyloop.backend.domain.user.SocialType;

public class NaverLoadStrategy extends SocialLoadStrategy {
	protected Map<String, Object> sendRequestToSocialSite(HttpEntity request) {
		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(SocialType.NAVER.getUserInfoUrl(),//
				SocialType.NAVER.getMethod(),
				request,
				RESPONSE_TYPE);
			Map<String, Object> responseInfo = (Map<String, Object>)response.getBody().get("response");
			return responseInfo;
		} catch (Exception e) {
			throw new NaverAccessTokenException();
		}
	}

	@Override
	public String getSocialPk(Map<String, Object> response) {
		return response.get("id").toString();
	}

	@Override
	public String getEmail(Map<String, Object> response) {
		return response.get("email").toString();
	}
}
