package com.xd.springcloudconfigserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitClientController {

    @Value("${xd.name}")
    private String name;

    @RequestMapping("/name")
    public String getName() {
        return name;
    }
}
