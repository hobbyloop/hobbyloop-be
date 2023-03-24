package com.hobbyloop.domain.lesson;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.instructor.Instructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Lesson extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    private int lessonCapacity;
    private int lessonEmptySpace;

    private LocalDateTime reservationDeadline;
    private LocalDateTime cancelDeadline;
    private LocalDateTime lessonDate;

}
