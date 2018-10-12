package com.xd.cloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*

    @Value("${msg}")
    private String msg;

    @RequestMapping("/hello")
    public String helo() {
        return msg;
    }

    */

    @RequestMapping("/hello")
    public String helo() {
        String s =null;
        s.length();
        return "";
    }
}
