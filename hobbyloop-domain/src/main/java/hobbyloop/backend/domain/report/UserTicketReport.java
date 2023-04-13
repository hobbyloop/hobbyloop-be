package hobbyloop.backend.domain.report;

import hobbyloop.backend.domain.ticket.UserTicket;

import javax.persistence.*;

@Entity
public class UserTicketReport extends Report {

    @ManyToOne
    @JoinColumn(name = "userTicketId")
    private UserTicket userTicket;
}
