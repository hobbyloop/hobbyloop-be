package hobbyloop.backend.domain.review;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.ticket.Ticket;
import hobbyloop.backend.domain.user.User;

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
