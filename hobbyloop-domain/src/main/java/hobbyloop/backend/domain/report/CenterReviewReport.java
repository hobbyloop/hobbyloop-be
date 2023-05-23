package hobbyloop.backend.domain.report;

import hobbyloop.backend.domain.review.CenterReview;

import javax.persistence.*;

@Entity
public class CenterReviewReport extends Report {

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private CenterReview centerReview;
}
