package hobbyloop.backend.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionStatus {

    TICKET_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST,"Global-001" ,"요청에 대한 Ticket Enum Type 을 찾을 수 없음"),
    TICKET_SORT_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST,"Global-001" ,"요청에 대한 Ticket Sort Enum Type 을 찾을 수 없음");

    private final HttpStatus httpStatus;
    private final String exceptionCode;
    private final String message;

    ExceptionStatus(HttpStatus httpStatus, String exceptionCode, String message) {
        this.httpStatus = httpStatus;
        this.exceptionCode = exceptionCode;
        this.message = message;
    }
}