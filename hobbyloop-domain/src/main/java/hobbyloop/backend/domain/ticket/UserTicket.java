package hobbyloop.backend.domain.ticket;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
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
