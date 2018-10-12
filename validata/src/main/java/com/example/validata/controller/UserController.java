package com.example.validata.controller;


import com.example.validata.pojo.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @RequestMapping("/adduser")
    public String addUserPage(@ModelAttribute("uu") Users users) {
        return "add";
    }

    /**
     * 添加用户
     *
     * @return
     * @Valid 开启对user的数据校验
     */
    @RequestMapping("/save")
    public String save(@ModelAttribute("uu") @Valid Users users, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        System.out.println(users);
        return "ok";
    }

    /**
     * 抛异常
     *
     * @return
     * @Valid 开启对user的数据校验
     */
    @RequestMapping("/ex1")
    public String ex1() {
        String s = null;
        s.length();
        return "ok";
    }

    /**
     * 抛异常
     *
     * @return
     * @Valid 开启对user的数据校验
     */
    @RequestMapping("/ex2")
    public String ex2() {
        int i = 10 / 0;
        return "ok";
    }


}
