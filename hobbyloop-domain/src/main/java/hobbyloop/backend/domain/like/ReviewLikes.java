package hobbyloop.backend.domain.like;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.review.Review;
import hobbyloop.backend.domain.user.User;

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
