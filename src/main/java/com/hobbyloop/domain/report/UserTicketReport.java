package com.hobbyloop.domain.report;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.ticket.UserTicket;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class UserTicketReport extends Report {

    @ManyToOne
    @JoinColumn(name = "userTicketId")
    private UserTicket userTicket;
}
