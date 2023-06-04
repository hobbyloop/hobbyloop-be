package hobbyloop.backend.api.infra.global.oauth2.strategy;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

public abstract class SocialLoadStrategy {

    ParameterizedTypeReference<Map<String, Object>> RESPONSE_TYPE  =  new ParameterizedTypeReference<>(){};

    protected final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getSocialInfo(String accessToken) {
        HttpHeaders headers = new HttpHeaders();

        setHeaders(accessToken, headers);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        return sendRequestToSocialSite(request);//구체 클래스가 구현
    }

    protected abstract Map<String, Object> sendRequestToSocialSite(HttpEntity request);

    public abstract String getSocialPk(Map<String, Object> response);

    public abstract String getEmail(Map<String, Object> response);

    public void setHeaders(String accessToken, HttpHeaders headers) {
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }
}
