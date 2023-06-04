package hobbyloop.backend.api.infra.config;

import hobbyloop.backend.api.applicationservice.user.UserApplicationService;
import hobbyloop.backend.api.infra.global.jwt.filter.JwtAuthenticationProcessingFilter;
import hobbyloop.backend.api.infra.global.jwt.service.JwtService;
import hobbyloop.backend.api.infra.global.oauth2.filter.OAuth2AccessTokenAuthenticationFilter;
import hobbyloop.backend.api.infra.global.oauth2.handler.OAuth2AuthenticationFailureHandler;
import hobbyloop.backend.api.infra.global.oauth2.handler.OAuth2AuthenticationSuccessHandler;
import hobbyloop.backend.api.infra.global.oauth2.provider.AccessTokenAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtService jwtService;
    private final UserApplicationService userApplicationService;
    private final AccessTokenAuthenticationProvider accessTokenAuthenticationProvider;
    private final OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler auth2AuthenticationFailureHandler;

    private final String[] SWAGGER = {
            "/v3/api-docs",
            "/swagger-resources/**", "/configuration/security", "/webjars/**",
            "/swagger-ui.html", "/swagger/**", "/swagger-ui/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                .authorizeRequests()

                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/favicon.ico", "/h2-console/**", "/api/v1/user", "/login/**").permitAll()
                .antMatchers(SWAGGER).permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(oAuth2AccessTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationProcessingFilter(), OAuth2AccessTokenAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() {
        JwtAuthenticationProcessingFilter jwtAuthenticationFilter = new JwtAuthenticationProcessingFilter(jwtService, userApplicationService);
        return jwtAuthenticationFilter;
    }

    @Bean
    public OAuth2AccessTokenAuthenticationFilter oAuth2AccessTokenAuthenticationFilter() {
        return new OAuth2AccessTokenAuthenticationFilter(
                accessTokenAuthenticationProvider, authenticationSuccessHandler, auth2AuthenticationFailureHandler);
    }
}
