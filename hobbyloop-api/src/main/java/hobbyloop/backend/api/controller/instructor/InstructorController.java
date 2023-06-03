package hobbyloop.backend.api.controller.instructor;

import hobbyloop.backend.api.applicationservice.instructor.InstructorApplicationService;
import hobbyloop.backend.api.controller.instructor.dto.InstructorInfoResponseDTO;
import hobbyloop.backend.api.infra.util.ApiResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
