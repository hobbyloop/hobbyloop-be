package hobbyloop.backend.api.controller.util;

import hobbyloop.backend.domain.ExceptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionResponse {
    private int status;
    private String exceptionCode;
    private String message;

    public ExceptionResponse(final ExceptionStatus exceptionStatus) {
        this.status = exceptionStatus.getHttpStatus().value();
        this.exceptionCode = exceptionStatus.getExceptionCode();
        this.message = exceptionStatus.getMessage();
    }

    public static ExceptionResponse from(ExceptionStatus exceptionStatus) {
        return new ExceptionResponse(exceptionStatus);
    }
}
