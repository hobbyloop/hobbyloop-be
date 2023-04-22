package hobbyloop.backend.api.user.controller.user;

import hobbyloop.backend.api.infra.util.ApiResponse;
import hobbyloop.backend.api.user.applicationservice.user.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserApplicationService userApplicationService;


}
