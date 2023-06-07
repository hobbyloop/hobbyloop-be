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
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.user.User;

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
