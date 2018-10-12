package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ThymeleafConller {
    @RequestMapping("/thyShow1")
    public String thyShow1(HttpServletRequest request, Model model) {
        model.addAttribute("msg", "第一个thymeleaf程序");
//        date
        model.addAttribute("date", new Date());
//        if
        model.addAttribute("sex", "男");
//        switch
        model.addAttribute("id", 2);
//list
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "蔡倩倩", 34));
        userList.add(new User(2, "蔡倩倩2", 45));
        userList.add(new User(3, "蔡倩倩2", 56));
        userList.add(new User(4, "蔡倩倩4", 45));
        model.addAttribute("list", userList);
//map
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("u1", new User(1, "蔡。。", 34));
        stringObjectHashMap.put("u2", new User(2, "张。。", 34));
        stringObjectHashMap.put("u3", new User(3, "冯。。", 34));
        stringObjectHashMap.put("u4", new User(4, "王。。", 34));
        model.addAttribute("map", stringObjectHashMap);
//        作用域
        request.setAttribute("req", "httpServletRequest");
        request.getSession().setAttribute("sess", "httpSession");
        request.getSession().getServletContext().setAttribute("app", "Application");
        return "index";
    }
}

