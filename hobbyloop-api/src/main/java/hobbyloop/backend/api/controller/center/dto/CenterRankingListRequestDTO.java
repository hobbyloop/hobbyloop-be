package hobbyloop.backend.api.controller.center.dto;

import hobbyloop.backend.domain.center.CenterSortType;
import hobbyloop.backend.domain.ticket.TicketType;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CenterRankingListRequestDTO {
    @ApiModelProperty(value = "유저 식별자", example = "1")
    private Long userId;

    @ApiModelProperty(value = "이용권의 카테고리", example = "헬스/PT")
    private String ticketType;

    @ApiModelProperty(value = "정렬 기준", example = "recently")
    private String sortType;
}
