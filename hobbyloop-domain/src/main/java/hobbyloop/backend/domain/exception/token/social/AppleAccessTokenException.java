package hobbyloop.backend.domain.exception.token.social;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class AppleAccessTokenException extends TokenException {
	public AppleAccessTokenException() {
		super(ExceptionStatus.APPLE_ACCESS_TOKEN_IS_WRONG);
	}
}
