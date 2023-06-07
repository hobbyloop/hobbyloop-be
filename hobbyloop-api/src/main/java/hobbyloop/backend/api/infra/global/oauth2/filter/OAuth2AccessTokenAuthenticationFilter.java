package hobbyloop.backend.api.infra.global.oauth2.filter;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import hobbyloop.backend.api.infra.global.oauth2.AccessTokenSocialTypeToken;
import hobbyloop.backend.api.infra.global.oauth2.provider.AccessTokenAuthenticationProvider;
import hobbyloop.backend.domain.exception.enumbinding.enumtype.SocialTypeBindingException;
import hobbyloop.backend.domain.exception.unexpectedURL.UnExpectedLoginURL;
import hobbyloop.backend.domain.user.SocialType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OAuth2AccessTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private static final String DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX = "/login/oauth2/";

	private static final String HTTP_METHOD = "GET";

	private static final String ACCESS_TOKEN_HEADER_NAME = "Authorization";

	private static final AntPathRequestMatcher DEFAULT_OAUTH2_LOGIN_PATH_REQUEST_MATCHER =
		new AntPathRequestMatcher(DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX + "*", HTTP_METHOD);

	public OAuth2AccessTokenAuthenticationFilter(AccessTokenAuthenticationProvider accessTokenAuthenticationProvider,
		AuthenticationSuccessHandler authenticationSuccessHandler,
		AuthenticationFailureHandler authenticationFailureHandler) {
		super(DEFAULT_OAUTH2_LOGIN_PATH_REQUEST_MATCHER);
		this.setAuthenticationManager(new ProviderManager(accessTokenAuthenticationProvider));
		this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		this.setAuthenticationFailureHandler(authenticationFailureHandler);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
		AuthenticationException {

		String social = extractSocialType(request);
		SocialType socialType = SocialType.of(social);

		String accessToken = request.getHeader(ACCESS_TOKEN_HEADER_NAME);
		log.info("{}", socialType.getSocialName());

		return this.getAuthenticationManager().authenticate(new AccessTokenSocialTypeToken(accessToken, socialType));
	}

	private String extractSocialType(HttpServletRequest request) {
		String social = request.getRequestURI().substring(DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX.length());
		if (social.isBlank() || !social.matches("^[a-zA-Z]*$")) {
			throw new UnExpectedLoginURL();
		}
		return social;
	}
}
