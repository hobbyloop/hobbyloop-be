package hobbyloop.backend.api.controller.util;

import hobbyloop.backend.domain.EnumTypeBindingException;
import hobbyloop.backend.domain.ExceptionStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * enum Type 불일치 Exception
     */
    @ExceptionHandler(EnumTypeBindingException.class)
    protected ResponseEntity<ExceptionResponse> handle(EnumTypeBindingException error) {
        log.error("handle error", error);
        final ExceptionResponse response = ExceptionResponse.from(ExceptionStatus.ENUM_TYPE_NOT_FOUND);
        return new ResponseEntity<>(response, ExceptionStatus.ENUM_TYPE_NOT_FOUND.getHttpStatus());
    }
}
