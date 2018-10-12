package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
    public String insertUser(Users users) {
        this.userService.insterUser(users);
        return "redirect:/user/findAll";
    }

    /**
     * 查询所有用户
     *
     * @param
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Users> serviceAll = this.userService.findAll();
        model.addAttribute("userList", serviceAll);
        return "selectUsers";
    }

    /**
     * 查询单个用户
     *
     * @param
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Model model, Integer id) {
        Users users = this.userService.findById(id);
        model.addAttribute("user", users);
        return "updateUser";
    }

    /**
     * 修改用户
     *
     * @param
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(Users users) {
        userService.updateUser(users);
        return "redirect:/user/findAll";
    }

    /**
     * 删除用户
     *
     * @param
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        userService.deleteById(id);
        return "redirect:/user/findAll";
    }

    /**
     * 删除用户
     *
     * @param
     * @return
     */
    @RequestMapping("/input")
    public String input() {
        return "input";
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
