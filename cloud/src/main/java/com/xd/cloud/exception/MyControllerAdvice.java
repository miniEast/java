package com.xd.cloud.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {


    @ResponseBody
    @ExceptionHandler(value = java.lang.Exception.class)
    public Map<String, Object> myException(Exception ex) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", "出错了，请联系管理员");
        return map;
    }
}
