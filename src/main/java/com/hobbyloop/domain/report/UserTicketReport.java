package com.hobbyloop.domain.report;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.ticket.UserTicket;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;


@Entity
public class UserTicketReport extends Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTicketReportId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "userTicketId")
    private UserTicket userTicket;
}
