package hobbyloop.backend.domain.exception.token.social;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class GoogleAccessTokenException extends TokenException {
	public GoogleAccessTokenException() {
		super(ExceptionStatus.GOOGLE_ACCESS_TOKEN_IS_WRONG);
	}
}
