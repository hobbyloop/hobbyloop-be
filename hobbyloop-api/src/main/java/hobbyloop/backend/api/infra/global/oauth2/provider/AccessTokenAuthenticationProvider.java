package hobbyloop.backend.api.infra.global.oauth2.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import hobbyloop.backend.api.infra.global.oauth2.AccessTokenSocialTypeToken;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.api.infra.global.oauth2.service.LoadUserService;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AccessTokenAuthenticationProvider implements AuthenticationProvider {

	private final LoadUserService loadUserService;
	private final UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		OAuth2UserDetails oAuth2User = loadUserService.getOAuth2UserDetails((AccessTokenSocialTypeToken)authentication);

		User user = userService.getOrCreateUser(oAuth2User.getUsername(), oAuth2User.getEmail());
		oAuth2User.setUser(user);

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
