package hobbyloop.backend.domain.exception.token.hobbyloop;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.token.TokenException;

public class RefreshTokenNotFoundException extends TokenException {
	public RefreshTokenNotFoundException() {
		super(ExceptionStatus.REFRESH_TOKEN_NOT_FOUND);
	}
}
