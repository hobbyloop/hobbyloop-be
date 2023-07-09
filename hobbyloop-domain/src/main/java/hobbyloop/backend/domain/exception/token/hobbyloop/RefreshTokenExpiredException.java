package hobbyloop.backend.domain.exception.token.hobbyloop;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class RefreshTokenExpiredException extends TokenException {
	public RefreshTokenExpiredException() {
		super(ExceptionStatus.REFRESH_TOKEN_IS_EXPIRED);
	}
}
