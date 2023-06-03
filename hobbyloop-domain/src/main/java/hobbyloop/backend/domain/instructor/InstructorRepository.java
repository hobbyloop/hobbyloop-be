package hobbyloop.backend.domain.instructor;

import hobbyloop.backend.domain.center.Center;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @EntityGraph(attributePaths = "lessons")
    List<Instructor> findAllByCenter(Center center);
}
