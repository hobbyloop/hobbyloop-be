package hobbyloop.backend.domain.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.review.CenterReview;
import hobbyloop.backend.domain.user.User;

@Entity
public class Comment extends BaseTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@ManyToOne
	@JoinColumn(name = "reviewId")
	private CenterReview centerReview;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	private String content;
}
