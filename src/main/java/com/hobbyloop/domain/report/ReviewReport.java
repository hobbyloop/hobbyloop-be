package com.hobbyloop.domain.report;

import com.hobbyloop.domain.review.Review;

import javax.persistence.*;


public class ReviewReport extends Report {

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
