package com.hobbyloop.domain.review;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.instructor.Instructor;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(value = EnumType.STRING)
    private ReviewStatus reviewStatus;

    private String content;
    private int viewCount;
    private int likeCount;
}
