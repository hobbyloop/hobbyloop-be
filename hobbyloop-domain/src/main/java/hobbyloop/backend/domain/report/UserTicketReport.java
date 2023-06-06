package hobbyloop.backend.domain.report;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.ticket.UserTicket;

@Entity
public class UserTicketReport extends Report {

	@ManyToOne
	@JoinColumn(name = "userTicketId")
	private UserTicket userTicket;
}
