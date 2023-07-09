package hobbyloop.backend.domain.exception.token.social;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class NaverAccessTokenException extends TokenException {
	public NaverAccessTokenException() {
		super(ExceptionStatus.NAVER_ACCESS_TOKEN_IS_WRONG);
	}
}
