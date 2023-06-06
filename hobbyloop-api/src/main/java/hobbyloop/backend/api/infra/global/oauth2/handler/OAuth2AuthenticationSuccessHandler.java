package hobbyloop.backend.api.infra.global.oauth2.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import hobbyloop.backend.api.applicationservice.user.UserApplicationService;
import hobbyloop.backend.api.infra.global.jwt.service.JwtService;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final JwtService jwtService;
	private final UserApplicationService userApplicationService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) {
		log.info("OAuth2 Login 성공!");
		try {
			OAuth2UserDetails userDetails = (OAuth2UserDetails)authentication.getPrincipal();
			loginSuccess(response, userDetails);
		} catch (Exception e) {
			log.error(e.toString());
		}
	}

	private void loginSuccess(HttpServletResponse response, OAuth2UserDetails userDetails) throws Exception {
		String accessToken = jwtService.createAccessToken(userDetails.getEmail());
		String refreshToken = jwtService.createRefreshToken();
		User user = userApplicationService.findByEmail(userDetails.getEmail()).orElseThrow(); // todo UserNotFoundException 추가
		user.updateAccessToken(accessToken);
		user.updateRefreshToken(refreshToken);
		response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
		response.addHeader(jwtService.getRefreshHeader(), "Bearer " + refreshToken);

		userApplicationService.updateUser(user);
	}
}
