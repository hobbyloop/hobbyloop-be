package hobbyloop.backend.domain;

public class BusinessException extends RuntimeException {
    private final ExceptionStatus exceptionStatus;

    public BusinessException(String message, ExceptionStatus exceptionStatus) {
        super(message);
        this.exceptionStatus = exceptionStatus;
    }

    public BusinessException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }

    public ExceptionStatus getErrorCode() {
        return exceptionStatus;
    }
}
