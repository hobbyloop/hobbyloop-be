package com.hobbyloop.domain.instructor;

import com.hobbyloop.domain.center.Center;

import javax.persistence.*;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    private String instructorIntroduction;
}
