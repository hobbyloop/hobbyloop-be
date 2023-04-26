package hobbyloop.backend.api.controller.user;

import hobbyloop.backend.api.applicationservice.user.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserApplicationService userApplicationService;


}
