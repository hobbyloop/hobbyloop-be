package com.hobbyloop.domain.ticket;

import com.hobbyloop.domain.BaseTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private String keyword;
    private int price;
    private int term;
    private int count;


}
