package hobbyloop.backend.domain.exception.token.social;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class KakaoAccessTokenException extends TokenException {
	public KakaoAccessTokenException() {
		super(ExceptionStatus.KAKAO_ACCESS_TOKEN_IS_WRONG);
	}
}
