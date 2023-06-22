package hobbyloop.backend.domain.ticket;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.user.User;
import lombok.Getter;

@Entity
@Getter
public class UserTicket extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userTicketId;

	@ManyToOne
	@JoinColumn(name = "ticketId")
	private Ticket ticket;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private LocalDate startDate;

	private LocalDate endDate;

	private int remainingDays;

	private int remainingCounts;
}
