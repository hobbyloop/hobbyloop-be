package hobbyloop.backend.domain.like;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.review.CenterReview;
import hobbyloop.backend.domain.user.User;

import javax.persistence.*;

@Entity
public class ReviewLikes extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewLikesId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private CenterReview centerReview;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
