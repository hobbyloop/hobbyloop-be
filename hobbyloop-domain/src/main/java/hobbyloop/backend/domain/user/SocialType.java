package hobbyloop.backend.domain.user;

import java.util.Arrays;

import org.springframework.http.HttpMethod;

import hobbyloop.backend.domain.center.CenterSortType;
import hobbyloop.backend.domain.exception.enumbinding.enumtype.CenterSortTypeBindingException;
import hobbyloop.backend.domain.exception.enumbinding.enumtype.SocialTypeBindingException;

public enum SocialType {
    KAKAO(
            "kakao",
            "https://kapi.kakao.com/v2/user/me",
            HttpMethod.GET
    ),

    GOOGLE(
            "google",
            "https://www.googleapis.com/oauth2/v3/userinfo",
            HttpMethod.GET
    ),

    NAVER(
            "naver",
            "https://openapi.naver.com/v1/nid/me",
            HttpMethod.GET
    );



    private final String socialName;
    private final String userInfoUrl;
    private final HttpMethod method;

    SocialType(String socialName, String userInfoUrl, HttpMethod method) {
        this.socialName = socialName;
        this.userInfoUrl = userInfoUrl;
        this.method = method;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getSocialName() {
        return socialName;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public static SocialType of(String socialName) {
        return Arrays.stream(SocialType.values())
            .filter(social -> social.getSocialName().equals(socialName))
            .findAny().orElseThrow(SocialTypeBindingException::new);
    }
}
