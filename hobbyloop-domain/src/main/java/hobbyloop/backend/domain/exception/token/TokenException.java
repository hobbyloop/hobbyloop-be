package hobbyloop.backend.domain.exception.token;

import hobbyloop.backend.domain.exception.BusinessException;
import hobbyloop.backend.domain.exception.ExceptionStatus;

public class TokenException extends BusinessException {

	public TokenException(ExceptionStatus exceptionStatus) {
		super(exceptionStatus);
	}
}
