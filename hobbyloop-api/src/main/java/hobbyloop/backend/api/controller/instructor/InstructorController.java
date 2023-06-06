package hobbyloop.backend.api.controller.instructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hobbyloop.backend.api.applicationservice.instructor.InstructorApplicationService;
import hobbyloop.backend.api.controller.instructor.dto.InstructorInfoResponseDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@Api(tags = {"강사 관련 API 정보를 제공하는 Controller 입니다."})
@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {
	private final InstructorApplicationService instructorApplicationService;

	@GetMapping("")
	public ApiResponse<List<InstructorInfoResponseDTO>> getInstructorsByCenter(
		@RequestParam Long centerId) {
		return ApiResponse.success(HttpStatus.OK,
			instructorApplicationService.getInstructorsByCenter(centerId));
	}
}
