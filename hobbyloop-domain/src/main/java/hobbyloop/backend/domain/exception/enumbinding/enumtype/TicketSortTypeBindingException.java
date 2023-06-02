package hobbyloop.backend.domain.exception.enumbinding.enumtype;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.enumbinding.EnumTypeBindingException;

public class TicketSortTypeBindingException extends EnumTypeBindingException {
    public TicketSortTypeBindingException() {
        super(ExceptionStatus.TICKET_SORT_TYPE_NOT_FOUND);
    }
}
