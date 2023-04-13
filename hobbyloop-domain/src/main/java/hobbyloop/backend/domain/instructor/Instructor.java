package hobbyloop.backend.domain.instructor;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;

import javax.persistence.*;

@Entity
public class Instructor extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    private String instructorIntroduction;
}
