package hobbyloop.backend.api.infra.global.oauth2.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import hobbyloop.backend.api.applicationservice.user.UserApplicationService;
import hobbyloop.backend.api.infra.global.oauth2.AccessTokenSocialTypeToken;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.api.infra.global.oauth2.service.LoadUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AccessTokenAuthenticationProvider implements AuthenticationProvider {

	private final LoadUserService loadUserService;
	private final UserApplicationService userApplicationService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		OAuth2UserDetails oAuth2User = loadUserService.getOAuth2UserDetails((AccessTokenSocialTypeToken)authentication);

		oAuth2User.setUser(userApplicationService.getOrCreateUserByDetails(oAuth2User));

		return AccessTokenSocialTypeToken.builder()
			.principal(oAuth2User)
			.authorities(oAuth2User.getAuthorities())
			.build();
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return AccessTokenSocialTypeToken.class.isAssignableFrom(authentication);
	}
}
