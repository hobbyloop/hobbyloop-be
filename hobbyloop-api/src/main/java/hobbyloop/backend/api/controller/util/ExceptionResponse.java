package hobbyloop.backend.api.controller.util;

import org.springframework.http.HttpStatus;

import hobbyloop.backend.domain.exception.BusinessException;
import hobbyloop.backend.domain.exception.ExceptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionResponse {
	private HttpStatus status;
	private String exceptionCode;
	private String message;

	public ExceptionResponse(final ExceptionStatus exceptionStatus) {
		this.status = exceptionStatus.getHttpStatus();
		this.exceptionCode = exceptionStatus.getExceptionCode();
		this.message = exceptionStatus.getMessage();
	}

	public static ExceptionResponse from(ExceptionStatus exceptionStatus) {
		return new ExceptionResponse(exceptionStatus);
	}

	public static ExceptionResponse from(BusinessException error) {
		return new ExceptionResponse(error.getErrorCode());
	}
}
