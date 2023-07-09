package hobbyloop.backend.domain.exception.token.hobbyloop;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class AccessTokenExpiredException extends TokenException {
	public AccessTokenExpiredException() {
		super(ExceptionStatus.ACCESS_TOKEN_IS_EXPIRED);
	}
}
