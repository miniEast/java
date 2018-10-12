package com.xd.eureka.controller;


import com.xd.eureka.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    @RequestMapping("/users")
    public List<User> getUser() {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "晓东", 18));
        userList.add(new User(2, "大熊", 10));
        userList.add(new User(3, "娜美", 44));
        return userList;
    }


    @RequestMapping("/feignServer")
    public String getUserList() {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "晓东", 18));
        userList.add(new User(2, "大熊", 10));
        userList.add(new User(3, "娜美", 44));
        return userList.toString();
    }
}
