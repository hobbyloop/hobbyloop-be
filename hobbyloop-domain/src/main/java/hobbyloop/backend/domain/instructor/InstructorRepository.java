package hobbyloop.backend.domain.instructor;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import hobbyloop.backend.domain.center.Center;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

	@EntityGraph(attributePaths = "lessons")
	List<Instructor> findAllByCenter(Center center);
}
