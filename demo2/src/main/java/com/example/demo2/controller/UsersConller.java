package com.example.demo2.controller;

import com.example.demo2.pojo.Users;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersConller {

    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     *
     * @param
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser( Users users) {
        this.userService.insterUser(users);
        return "ok";
    }

    /**
     * 页面跳转
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }


}
