package hobbyloop.backend.domain.ticket;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.center.Center;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

	private final TicketRepository ticketRepository;

	@Transactional
	public Ticket createTicket(String ticketName, LocalDate ticketStartDate, LocalDate ticketEndDate, int amount,
		int price, int discountRate, Center center) {
		return ticketRepository.save(
			Ticket.builder()
				.ticketName(ticketName)
				.ticketStartDate(ticketStartDate)
				.ticketEndDate(ticketEndDate)
				.amount(amount)
				.price(price)
				.discountRate(discountRate)
				.center(center)
				.build()
		);
	}

}
