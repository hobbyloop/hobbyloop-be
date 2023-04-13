package hobbyloop.backend.domain.report;

import hobbyloop.backend.domain.review.Review;

import javax.persistence.*;

@Entity
public class ReviewReport extends Report {

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;
}
