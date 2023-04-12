package com.hobbyloop.domain.reservation;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.lesson.Lesson;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class Reservation extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "lessonId")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
}
