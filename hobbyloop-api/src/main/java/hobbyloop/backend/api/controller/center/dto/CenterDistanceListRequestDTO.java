package hobbyloop.backend.api.controller.center.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CenterDistanceListRequestDTO {
    @ApiModelProperty(value = "유저 식별자", example = "1")
    private Long userId;

    @ApiModelProperty(value = "이용권의 카테고리", example = "헬스/PT")
    private String ticketType;

    @ApiModelProperty(value = "위도", example = "35.5")
    private double mapy;

    @ApiModelProperty(value = "경도", example = "136.7")
    private double mapx;
}
