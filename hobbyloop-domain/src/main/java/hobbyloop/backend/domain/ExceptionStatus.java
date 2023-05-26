package hobbyloop.backend.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionStatus {

    ENUM_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST,"Global-001" ,"요청에 대한 Enum Type 을 찾을 수 없음");

    private final HttpStatus httpStatus;
    private final String exceptionCode;
    private final String message;

    ExceptionStatus(HttpStatus httpStatus, String exceptionCode, String message) {
        this.httpStatus = httpStatus;
        this.exceptionCode = exceptionCode;
        this.message = message;
    }
}
