package com.example.demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.demo2.mapper") //扫描mapper接口
public class Demo2Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }
}
