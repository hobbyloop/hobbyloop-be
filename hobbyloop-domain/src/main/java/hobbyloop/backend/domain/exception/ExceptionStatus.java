package hobbyloop.backend.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionStatus {

    TICKET_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST,"Global-001" ,"요청에 대한 Ticket Enum Type 을 찾을 수 없음"),
    CENTER_SORT_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST,"Global-001" ,"요청에 대한 Center Sort Enum Type 을 찾을 수 없음"),
    NOT_SUPPORTED_SOCIAL_TYPE(HttpStatus.BAD_REQUEST, "Global-001" ,"요청에 대한 SOCIAL Enum Type 을 찾을 수 없음"),
    CANNOT_EXTRACT_SOCIAL_NAME_IN_URL(HttpStatus.BAD_REQUEST, "Global-001" ,"요청 주소에서 socialName 을 추출할 수 없음");

    private final HttpStatus httpStatus;
    private final String exceptionCode;
    private final String message;

    ExceptionStatus(HttpStatus httpStatus, String exceptionCode, String message) {
        this.httpStatus = httpStatus;
        this.exceptionCode = exceptionCode;
        this.message = message;
    }
}
