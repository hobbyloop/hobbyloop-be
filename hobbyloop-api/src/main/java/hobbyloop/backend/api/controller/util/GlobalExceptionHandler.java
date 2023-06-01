package hobbyloop.backend.api.controller.util;

import hobbyloop.backend.domain.exception.enumbinding.EnumTypeBindingException;
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
        log.error("HANDLE ERROR - {}", error.toString());
        ExceptionResponse exceptionResponse = ExceptionResponse.from(error);
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }
}
