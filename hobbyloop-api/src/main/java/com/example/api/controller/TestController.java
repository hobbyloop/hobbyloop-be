package com.example.api.controller;

import com.hobbyloop.domain.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        User user = new User();
        user.setUserId(1L);
        user.setSocialEmail("whdgh9873@naver.com");
        return "userId = " + user.getUserId() + "socialEmail = " + user.getSocialEmail();
    }

}
