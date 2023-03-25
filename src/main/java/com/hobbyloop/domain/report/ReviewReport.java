package com.hobbyloop.domain.report;

import com.hobbyloop.domain.center.Center;
import com.hobbyloop.domain.review.Review;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class ReviewReport extends Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewReportId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
