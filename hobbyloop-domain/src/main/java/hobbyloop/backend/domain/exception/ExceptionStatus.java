package hobbyloop.backend.domain.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ExceptionStatus {

	/*
		enum type binding exception
	 */
	TICKET_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST, "Global-001", "요청에 대한 Ticket Enum Type 을 찾을 수 없음"),

	CENTER_SORT_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST, "Global-002", "요청에 대한 Center Sort Enum Type 을 찾을 수 없음"),

	NOT_SUPPORTED_SOCIAL_TYPE(HttpStatus.BAD_REQUEST, "Global-003", "요청에 대한 SOCIAL Enum Type 을 찾을 수 없음"),

	CANNOT_EXTRACT_SOCIAL_NAME_IN_URL(HttpStatus.BAD_REQUEST, "Global-004", "요청 주소에서 socialName 을 추출할 수 없음"),

	/*
		entity not found exception
	*/
	ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST, "Global-005", "요청에 대한 Entity 를 찾을 수 없음"),

	/*
		token exception
	*/
	ACCESS_TOKEN_IS_EXPIRED(HttpStatus.BAD_REQUEST, "Global-006", "엑세스 토큰이 만료됨"),

	REFRESH_TOKEN_IS_EXPIRED(HttpStatus.BAD_REQUEST, "Global-007", "리프레시 토큰이 만료됨"),

	REFRESH_TOKEN_NOT_FOUND(HttpStatus.BAD_REQUEST, "Global-008", "리프레시 토큰을 찾을 수 없음"),

	KAKAO_ACCESS_TOKEN_IS_WRONG(HttpStatus.BAD_REQUEST, "Global-009", "카카오 엑세스 토큰으로 정보를 가져오는중 문제 발생"),

	GOOGLE_ACCESS_TOKEN_IS_WRONG(HttpStatus.BAD_REQUEST, "Global-010", "구글 엑세스 토큰으로 정보를 가져오는중 문제 발생"),

	NAVER_ACCESS_TOKEN_IS_WRONG(HttpStatus.BAD_REQUEST, "Global-011", "네이버 엑세스 토큰으로 정보를 가져오는중 문제 발생"),

	APPLE_ACCESS_TOKEN_IS_WRONG(HttpStatus.BAD_REQUEST, "Global-012", "애플 엑세스 토큰으로 정보를 가져오는중 문제 발생");

	private final HttpStatus httpStatus;
	private final String exceptionCode;
	private final String message;

	ExceptionStatus(HttpStatus httpStatus, String exceptionCode, String message) {
		this.httpStatus = httpStatus;
		this.exceptionCode = exceptionCode;
		this.message = message;
	}
}
