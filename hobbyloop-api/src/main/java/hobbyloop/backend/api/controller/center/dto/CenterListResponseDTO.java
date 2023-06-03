package hobbyloop.backend.api.controller.center.dto;

import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.center.CenterDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CenterListResponseDTO {

    @ApiModelProperty(value = "업체 식별자", example = "1")
    private Long centerId;

    @ApiModelProperty(value = "업체명", example = "에이블짐 창신점")
    private String centerName;

    @ApiModelProperty(value = "대표 이미지")
    private String repImageUrl;

    @ApiModelProperty(value = "주소", example = "서울시 강북구 --- | 현재 구체적인 포멧은 미정")
    private String address;

    @ApiModelProperty(value = "평점", example = "4.333333")
    private double score;

    @ApiModelProperty(value = "이용권 개수", example = "1")
    private int tickets;

    @ApiModelProperty(value = "북마크 여부", example = "false")
    private boolean isBookmarked;

    @ApiModelProperty(value = "경도", example = "126.9")
    private double mapx;

    @ApiModelProperty(value = "위도", example = "37.5")
    private double mapy;

    public static CenterListResponseDTO from(CenterDTO centerDTO) {
        return CenterListResponseDTO.builder()
                .centerId(centerDTO.getCenterId())
                .centerName(centerDTO.getCenterName())
                .repImageUrl(centerDTO.getRepImageUrl())
                .address(centerDTO.getAddress())
                .score(centerDTO.getScore())
                .tickets((int) centerDTO.getTickets())
                .isBookmarked(centerDTO.isBookmarked())
                .build();
    }
}
