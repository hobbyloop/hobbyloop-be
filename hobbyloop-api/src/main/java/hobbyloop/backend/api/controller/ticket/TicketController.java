package hobbyloop.backend.api.controller.ticket;

import hobbyloop.backend.api.applicationservice.ticket.TicketApplicationService;
import hobbyloop.backend.api.controller.ticket.dto.GetTicketListResponseDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketApplicationService ticketApplicationService;

    @GetMapping("/list/ranking")
    public ApiResponse<List<GetTicketListResponseDTO>> getTicketsWithRanking(
            @RequestParam String ticketType,
            @RequestParam String sortType
    ) {
        return ApiResponse.success(HttpStatus.OK,
                ticketApplicationService.getTicketsWithRanking(ticketType, sortType));
    }
}
