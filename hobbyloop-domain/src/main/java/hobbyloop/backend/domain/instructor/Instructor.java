package hobbyloop.backend.domain.instructor;

import hobbyloop.backend.domain.BaseTime;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.lesson.Lesson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Instructor extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    private String instructorName;

    private String instructorRepImageUrl;

    private String instructorIntroduction;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @OneToMany(mappedBy = "instructor")
    private List<Lesson> lessons = new ArrayList<>();
}
