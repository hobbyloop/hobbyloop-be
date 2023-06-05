package hobbyloop.backend.domain.exception.enumbinding.enumtype;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.enumbinding.EnumTypeBindingException;

public class CenterSortTypeBindingException extends EnumTypeBindingException {

	public CenterSortTypeBindingException() {
		super(ExceptionStatus.CENTER_SORT_TYPE_NOT_FOUND);
	}
}
