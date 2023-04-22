package hobbyloop.backend.api.infra.global.oauth2.handler;

import hobbyloop.backend.api.infra.global.jwt.service.JwtService;
import hobbyloop.backend.api.infra.global.oauth2.CustomOAuth2User;
import hobbyloop.backend.api.user.applicationservice.user.UserApplicationService;
import hobbyloop.backend.domain.user.Role;
import hobbyloop.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
//@Transactional
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserApplicationService userApplicationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login 성공!");
        try {
            CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

            // User의 Role이 GUEST일 경우 처음 요청한 회원이므로 회원가입 페이지로 리다이렉트
            if(oAuth2User.getRole() == Role.GUEST) {
                String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
                response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
                response.sendRedirect("/"); // 프론트의 회원가입 추가 정보 입력 폼으로 리다이렉트

                jwtService.sendAccessAndRefreshToken(response, accessToken, null);
//                User findUser = userRepository.findByEmail(oAuth2User.getEmail())
//                                .orElseThrow(() -> new IllegalArgumentException("이메일에 해당하는 유저가 없습니다."));
//                findUser.authorizeUser();
            } else {
                loginSuccess(response, oAuth2User); // 로그인에 성공한 경우 access, refresh 토큰 생성
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            throw e;
        }

    }

    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
        String refreshToken = jwtService.createRefreshToken();
        User user = userApplicationService.findByEmail(oAuth2User.getEmail()).orElseThrow();
        user.updateAccessToken(accessToken);
        user.updateRefreshToken(refreshToken);
        response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
        response.addHeader(jwtService.getRefreshHeader(), "Bearer " + refreshToken);

        userApplicationService.updateUser(user);
        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);
        jwtService.updateRefreshToken(oAuth2User.getEmail(), refreshToken);
    }
}
