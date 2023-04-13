package hobbyloop.backend.domain.comment;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.review.Review;
import hobbyloop.backend.domain.user.User;

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
