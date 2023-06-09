package hobbyloop.backend.api.controller.center.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CenterRankingListRequestDTO {
	@ApiModelProperty(value = "이용권의 카테고리", example = "헬스/PT")
	private String ticketType;

	@ApiModelProperty(value = "정렬 기준", example = "recently")
	private String sortType;
}
