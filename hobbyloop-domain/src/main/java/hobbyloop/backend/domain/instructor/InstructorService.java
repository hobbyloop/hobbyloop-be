package hobbyloop.backend.domain.instructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hobbyloop.backend.domain.center.Center;
import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class InstructorService {
	private final InstructorRepository instructorRepository;

	public List<Instructor> getInstructorsWithLessonsByCenter(Center center) {
		return instructorRepository.findAllByCenter(center);
	}
}
