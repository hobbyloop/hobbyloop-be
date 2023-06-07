package hobbyloop.backend.api.controller.ticket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hobbyloop.backend.api.applicationservice.ticket.TicketApplicationService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@Api(tags = {"이용권 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private final TicketApplicationService ticketApplicationService;
}
