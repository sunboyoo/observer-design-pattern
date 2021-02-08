package org.lcm.observerdesignpattern.mainapplication.controller;

import org.lcm.observerdesignpattern.userservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public String createUser(){
        int userId = new Random().nextInt();
        logger.info("POST /users userId={}", userId);

        // 执行 UserService 逻辑
        userService.register(userId);

        return "POST /users userId=" + userId;
    }
}
