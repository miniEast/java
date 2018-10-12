package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Helloword {
    @RequestMapping("hello")
    @ResponseBody
    public Map<String,Object> showHellowprd(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("msg","helloword");
        return stringObjectHashMap;
    }
}
