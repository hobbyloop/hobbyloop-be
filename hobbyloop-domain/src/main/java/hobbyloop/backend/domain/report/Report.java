package hobbyloop.backend.domain.report;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.user.User;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Report extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User reporter;
    private String reportMessage;

}
