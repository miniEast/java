package com.example.validata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {
    @RequestMapping("/ex3")
    public String ex1() {
        String s = null;
        s.length();
        return "ok";
    }

    @RequestMapping("/ex4")
    public String ex2() {
        int i = 10 / 0;
        return "ok";
    }
}
