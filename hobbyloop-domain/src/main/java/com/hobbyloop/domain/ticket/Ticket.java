package com.hobbyloop.domain.ticket;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.instructor.Instructor;

import javax.persistence.*;

@Entity
public class Ticket extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    private String keyword;
    private int price;
    private int days;
    private int count;


}
