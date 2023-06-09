package hobbyloop.backend.domain.exception.unexpectedURL;

import hobbyloop.backend.domain.exception.BusinessException;
import hobbyloop.backend.domain.exception.ExceptionStatus;

public class UnExpectedURLException extends BusinessException {
	public UnExpectedURLException(ExceptionStatus exceptionStatus) {
		super(exceptionStatus);
	}
}
