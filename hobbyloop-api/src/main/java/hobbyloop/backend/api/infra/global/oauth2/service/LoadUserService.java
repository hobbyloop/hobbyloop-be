package hobbyloop.backend.api.infra.global.oauth2.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import hobbyloop.backend.api.infra.global.oauth2.AccessTokenSocialTypeToken;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.api.infra.global.oauth2.strategy.GoogleLoadStrategy;
import hobbyloop.backend.api.infra.global.oauth2.strategy.KakaoLoadStrategy;
import hobbyloop.backend.api.infra.global.oauth2.strategy.NaverLoadStrategy;
import hobbyloop.backend.api.infra.global.oauth2.strategy.SocialLoadStrategy;
import hobbyloop.backend.domain.exception.enumbinding.enumtype.SocialTypeBindingException;
import hobbyloop.backend.domain.user.SocialType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoadUserService {

	public OAuth2UserDetails getOAuth2UserDetails(AccessTokenSocialTypeToken authentication) {

		SocialType socialType = authentication.getSocialType();
		SocialLoadStrategy socialLoadStrategy = getSocialLoadStrategy(socialType);

		Map<String, Object> socialInfo = socialLoadStrategy.getSocialInfo(authentication.getAccessToken());
		String socialPk = socialLoadStrategy.getSocialPk(socialInfo);
		String email = socialLoadStrategy.getEmail(socialInfo);

		return OAuth2UserDetails.builder()
			.socialId(socialPk)
			.socialType(socialType)
			.email(email)
			.build();
	}

	private SocialLoadStrategy getSocialLoadStrategy(SocialType socialType) {
		switch (socialType) {
			case KAKAO:
				return new KakaoLoadStrategy();
			case GOOGLE:
				return new GoogleLoadStrategy();
			case NAVER:
				return new NaverLoadStrategy();
			default:
				throw new SocialTypeBindingException();
		}
	}
}
