package hobbyloop.backend.api.controller.ticket.dto;

import hobbyloop.backend.domain.ticket.Ticket;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class GetTicketListResponseDTO {

    @ApiModelProperty(value = "업체명", example = "에이블짐 창신점")
    private String centerName;

    @ApiModelProperty(value = "주소", example = "서울시 강북구 --- | 현재 구체적인 포멧은 미정")
    private String address;

    @ApiModelProperty(value = "가격", example = "50000")
    private int price;

    @ApiModelProperty(value = "평점", example = "4.333333")
    private double score;

    public static GetTicketListResponseDTO from(Ticket ticket) {
        return GetTicketListResponseDTO.builder()
                .centerName(ticket.getCenter().getName())
                .address(ticket.getCenter().getAddress())
                .price(ticket.getPrice())
                .score(ticket.getScore())
                .build();
    }
}
