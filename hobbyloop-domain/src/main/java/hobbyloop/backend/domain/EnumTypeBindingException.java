package hobbyloop.backend.domain;

public class EnumTypeBindingException extends BusinessException {

    public EnumTypeBindingException() {
        super(ExceptionStatus.ENUM_TYPE_NOT_FOUND);
    }
}
