package hobbyloop.backend.api.controller;

import hobbyloop.backend.domain.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        User user = new User();
        user.setUserId(1L);
        user.setIntroduction("deploy test");
        return "userId = " + user.getUserId() + "socialEmail = " + user.getIntroduction();
    }

}
