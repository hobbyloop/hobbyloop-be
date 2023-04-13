package hobbyloop.backend.domain.review;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.instructor.Instructor;
import hobbyloop.backend.domain.user.User;

import javax.persistence.*;

@Entity
public class Review extends BaseTime {
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
