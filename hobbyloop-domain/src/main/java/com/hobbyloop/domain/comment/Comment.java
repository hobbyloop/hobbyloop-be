package com.hobbyloop.domain.comment;

import com.hobbyloop.domain.BaseTime;
import com.hobbyloop.domain.review.Review;
import com.hobbyloop.domain.user.User;

import javax.persistence.*;

@Entity
public class Comment extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String content;
}
