package hobbyloop.backend.api.controller.center.dto;

import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCenterRequestDTO {
	@ApiModelProperty(value = "대표자 이름", example = "임종호")
	private String centerName;

	@ApiModelProperty(value = "전화번호", example = "01038843144")
	private String phoneNumber;

	@ApiModelProperty(value = "사업장 주소", example = "서울특별시 성북구 동소문로 8-13")
	private String address;

	@ApiModelProperty(value = "사업자 번호", example = "126723712")
	private String businessNumber;

	@ApiModelProperty(value = "계좌번호", example = "임종호")
	private String accountNumber;

	@ApiModelProperty(value = "위도(y좌표)", example = "36.123123")
	private double latitude;

	@ApiModelProperty(value = "경도(x좌표)", example = "127.123123")
	private double longitude;

}
