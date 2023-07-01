package hobbyloop.backend.api.controller.center.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterFacilityRequestDTO {
	@ApiModelProperty(value = "시설 이름", example = "몸짱짐")
	private String facilityName;

	@ApiModelProperty(value = "사업장 주소", example = "서울특별시 성북구 동소문로 8-13")
	private String address;

	@ApiModelProperty(value = "시설 소개", example = "소개글을 입력해주세요")
	private String facilityIntroduction;

	@ApiModelProperty(value = "전화번호", example = "01038843144")
	private String phoneNumber;

	@ApiModelProperty(value = "운영 시작 시간", example = "HH:mm:ss")
	private String operatingStartTime;

	@ApiModelProperty(value = "운영 종료 시간", example = "HH:mm:ss")
	private String operatingEndTime;
}
