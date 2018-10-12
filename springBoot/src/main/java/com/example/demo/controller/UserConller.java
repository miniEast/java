package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserConller {
    // freemarker
    @RequestMapping("/showUser")
    public String showUser(Integer id, String name, Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(id, name, 34));
        userList.add(new User(2, "蔡倩倩2", 45));
        userList.add(new User(3, "蔡倩倩2", 56));
        userList.add(new User(4, "蔡倩倩4", 45));
        //产生model
        model.addAttribute("list", userList);
        //        跳转视图
        return "userList";
    }

    //jsp
    @RequestMapping("/showJspUser")
    public String showJspUser(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "蔡倩倩", 34));
        userList.add(new User(2, "蔡倩倩2", 45));
        userList.add(new User(3, "蔡倩倩2", 56));
        userList.add(new User(4, "蔡倩倩4", 45));
        //产生model
        model.addAttribute("list", userList);
        //        跳转视图
        return "userJspList";
    }
}
