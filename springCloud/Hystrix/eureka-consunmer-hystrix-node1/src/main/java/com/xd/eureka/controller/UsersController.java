package com.xd.eureka.controller;


import com.xd.eureka.pojo.User;
import com.xd.eureka.service.FeignClientI;
import com.xd.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private FeignClientI feignClientI;

    @RequestMapping("/consumer")
    public List<User> getUser() {
        return userService.getUsers();
    }

    @RequestMapping("/feignClient")
    public String feignClient() {
        return feignClientI.hello();
    }
}
