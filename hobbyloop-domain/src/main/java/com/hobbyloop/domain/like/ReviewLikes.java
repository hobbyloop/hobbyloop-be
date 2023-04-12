package com.hobbyloop.domain.like;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.review.Review;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class ReviewLikes extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewLikesId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
