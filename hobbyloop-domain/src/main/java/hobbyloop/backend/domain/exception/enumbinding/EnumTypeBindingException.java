package hobbyloop.backend.domain.exception.enumbinding;

import hobbyloop.backend.domain.exception.BusinessException;
import hobbyloop.backend.domain.exception.ExceptionStatus;

public class EnumTypeBindingException extends BusinessException {

    public EnumTypeBindingException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }
}
