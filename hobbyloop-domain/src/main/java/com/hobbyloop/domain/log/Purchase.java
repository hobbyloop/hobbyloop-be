package com.hobbyloop.domain.log;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.instructor.Instructor;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    private int price;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
