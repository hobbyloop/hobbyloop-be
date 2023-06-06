package hobbyloop.backend.api.infra.global.oauth2;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import hobbyloop.backend.domain.user.SocialType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AccessTokenSocialTypeToken extends AbstractAuthenticationToken {

    private Object principal; // OAuth2UserDetails 타입

    private String accessToken;
    private SocialType socialType;

    public AccessTokenSocialTypeToken(String accessToken, SocialType socialType) {
        super(null);
        this.accessToken = accessToken;
        this.socialType = socialType;
        setAuthenticated(false);
    }

    @Builder
    public AccessTokenSocialTypeToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
