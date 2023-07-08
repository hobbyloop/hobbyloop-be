package hobbyloop.backend.api.controller.ticket.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTicketRequestDTO {
	@ApiModelProperty(value = "이용권 이름", example = "임종호")
	private String ticketName;

	@ApiModelProperty(value = "사업장 주소", example = "서울특별시 성북구 동소문로 8-13")
	private String address;

	@ApiModelProperty(value = "이용권 소개", example = "소개글을 입력해주세요")
	private String ticketIntroduction;

	@ApiModelProperty(value = "전화번호", example = "01038843144")
	private String phoneNumber;

	@ApiModelProperty(value = "운영 시작 시간", example = "HH:mm:ss")
	private String operatingStartTime;

	@ApiModelProperty(value = "운영 종료 시간", example = "HH:mm:ss")
	private String operatingEndTime;

	@ApiModelProperty(value = "이용권 시작 날짜", example = "yyyy-MM-dd")
	private String ticketStartDate;

	@ApiModelProperty(value = "이용권 종료 날쩌", example = "yyyy-MM-dd")
	private String ticketEndDate;

	@ApiModelProperty(value = "이용권 총 수량", example = "10")
	private int amount;

	@ApiModelProperty(value = "이용권 가격", example = "10000")
	private int price;

	@ApiModelProperty(value = "이용권 할인율", example = "15")
	private int discountRate;
}
