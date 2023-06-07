package hobbyloop.backend.domain.report;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import hobbyloop.backend.domain.review.CenterReview;

@Entity
public class CenterReviewReport extends Report {

	@ManyToOne
	@JoinColumn(name = "reviewId")
	private CenterReview centerReview;
}
