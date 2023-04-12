package com.hobbyloop.domain.reservation;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.center.Center;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CounselingReservation extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long counselingReservationId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    private LocalDateTime counselingTime;
}
