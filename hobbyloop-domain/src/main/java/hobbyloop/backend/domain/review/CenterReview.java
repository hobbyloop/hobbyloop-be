package hobbyloop.backend.domain.review;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.instructor.Instructor;
import hobbyloop.backend.domain.user.User;

import javax.persistence.*;

@Entity
public class CenterReview extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerReviewId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User writer;

    @Enumerated(value = EnumType.STRING)
    private ReviewStatus reviewStatus;

    private String content;
    private int viewCount;
    private int likeCount;
}
