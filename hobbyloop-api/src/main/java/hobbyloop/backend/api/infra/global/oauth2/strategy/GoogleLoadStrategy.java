package hobbyloop.backend.api.infra.global.oauth2.strategy;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import hobbyloop.backend.domain.exception.token.social.GoogleAccessTokenException;
import hobbyloop.backend.domain.user.SocialType;

public class GoogleLoadStrategy extends SocialLoadStrategy {
	protected Map<String, Object> sendRequestToSocialSite(HttpEntity request) {
		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(SocialType.GOOGLE.getUserInfoUrl(),
				SocialType.GOOGLE.getMethod(),
				request,
				RESPONSE_TYPE);
			return response.getBody();
		} catch (Exception e) {
			throw new GoogleAccessTokenException();
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
