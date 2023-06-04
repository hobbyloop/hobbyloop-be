package hobbyloop.backend.api.infra.global.oauth2.handler;

import hobbyloop.backend.api.applicationservice.user.UserApplicationService;
import hobbyloop.backend.api.infra.global.jwt.service.JwtService;
import hobbyloop.backend.api.infra.global.oauth2.OAuth2UserDetails;
import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserApplicationService userApplicationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login 성공!");
        try {
            OAuth2UserDetails userDetails = (OAuth2UserDetails) authentication.getPrincipal();
            loginSuccess(response, userDetails);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("이메일에 해당하는 유저가 생성되지 않았습니다");
        }
    }

    private void loginSuccess(HttpServletResponse response, OAuth2UserDetails userDetails) throws Exception {
        String accessToken = jwtService.createAccessToken(userDetails.getEmail());
        String refreshToken = jwtService.createRefreshToken();
        User user = userApplicationService.findByEmail(userDetails.getEmail()).orElseThrow();
        user.updateAccessToken(accessToken);
        user.updateRefreshToken(refreshToken);
        response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
        response.addHeader(jwtService.getRefreshHeader(), "Bearer " + refreshToken);

        userApplicationService.updateUser(user);
    }
}
