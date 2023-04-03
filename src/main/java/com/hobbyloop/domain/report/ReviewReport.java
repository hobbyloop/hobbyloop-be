package com.hobbyloop.domain.report;

import com.hobbyloop.domain.review.Review;

import javax.persistence.*;

@Entity
public class ReviewReport extends Report {

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
