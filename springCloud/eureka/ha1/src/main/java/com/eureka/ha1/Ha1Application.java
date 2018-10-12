package com.eureka.ha1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Ha1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ha1Application.class, args);
    }
}
