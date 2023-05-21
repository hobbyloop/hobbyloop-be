package hobbyloop.backend.api.controller.ticket.dto;

import hobbyloop.backend.domain.ticket.Ticket;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class GetTicketListResponseDTO {
    private String centerName;
    private String address;
    private int price;
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
