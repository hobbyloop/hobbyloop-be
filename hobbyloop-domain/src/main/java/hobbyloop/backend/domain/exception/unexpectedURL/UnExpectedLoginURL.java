package hobbyloop.backend.domain.exception.unexpectedURL;

import hobbyloop.backend.domain.exception.ExceptionStatus;

public class UnExpectedLoginURL extends UnExpectedURLException {
	public UnExpectedLoginURL() {
		super(ExceptionStatus.CANNOT_EXTRACT_SOCIAL_NAME_IN_URL);
	}
}
