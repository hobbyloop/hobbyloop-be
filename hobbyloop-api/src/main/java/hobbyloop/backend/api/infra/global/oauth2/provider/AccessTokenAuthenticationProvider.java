package hobbyloop.backend.api.infra.global.oauth2.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import hobbyloop.backend.api.infra.global.oauth2.AccessTokenSocialTypeToken;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.api.infra.global.oauth2.service.LoadUserService;
import hobbyloop.backend.domain.user.Role;
import hobbyloop.backend.domain.user.User;
import hobbyloop.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AccessTokenAuthenticationProvider implements AuthenticationProvider {

	private final LoadUserService loadUserService;
	private final UserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		OAuth2UserDetails oAuth2User = loadUserService.getOAuth2UserDetails((AccessTokenSocialTypeToken)authentication);

		User user = saveOrGet(oAuth2User);
		oAuth2User.setRoles(user.getRole().name());

		return AccessTokenSocialTypeToken.builder()
			.principal(oAuth2User)
			.authorities(oAuth2User.getAuthorities())
			.build();
	}

	private User saveOrGet(OAuth2UserDetails oAuth2User) {
		return userRepository.findByEmail(oAuth2User.getEmail())
			.orElseGet(() -> userRepository.save(
				User.builder()
					.socialType(oAuth2User.getSocialType())
					.socialId(oAuth2User.getSocialId())
					.email(oAuth2User.getEmail())
					.role(Role.GUEST)
					.build())
			);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return AccessTokenSocialTypeToken.class.isAssignableFrom(authentication);
	}
}
