package hobbyloop.backend.domain.exception.enumbinding.enumtype;

import hobbyloop.backend.domain.exception.ExceptionStatus;
import hobbyloop.backend.domain.exception.enumbinding.EnumTypeBindingException;

public class SocialTypeBindingException extends EnumTypeBindingException {
	public SocialTypeBindingException() {
		super(ExceptionStatus.NOT_SUPPORTED_SOCIAL_TYPE);
	}
}
