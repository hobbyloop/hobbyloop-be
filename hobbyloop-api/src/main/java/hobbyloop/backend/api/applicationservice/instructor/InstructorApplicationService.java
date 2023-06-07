package hobbyloop.backend.api.applicationservice.instructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hobbyloop.backend.api.controller.instructor.dto.InstructorInfoResponseDTO;
import hobbyloop.backend.domain.center.Center;
import hobbyloop.backend.domain.center.CenterService;
import hobbyloop.backend.domain.instructor.InstructorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorApplicationService {
	private final CenterService centerService;
	private final InstructorService instructorService;

	public List<InstructorInfoResponseDTO> getInstructorsByCenter(Long centerId) {
		Center center = centerService.getCenterById(centerId);
		return instructorService.getInstructorsWithLessonsByCenter(center).stream()
			.map(InstructorInfoResponseDTO::from)
			.collect(Collectors.toList());
	}
}
