package hobbyloop.backend.domain.review;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.instructor.Instructor;
import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.user.User;

import javax.persistence.*;

@Entity
public class TicketReview extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketReviewId;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User writer;

    @Enumerated(value = EnumType.STRING)
    private ReviewStatus reviewStatus;

    private String content;
    private int viewCount;
    private int likeCount;
}
