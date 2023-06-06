package hobbyloop.backend.domain.exception.enumbinding.enumtype;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.enumbinding.EnumTypeBindingException;

public class TicketTypeBindingException extends EnumTypeBindingException {

	public TicketTypeBindingException() {
		super(ExceptionStatus.TICKET_TYPE_NOT_FOUND);
	}
}
