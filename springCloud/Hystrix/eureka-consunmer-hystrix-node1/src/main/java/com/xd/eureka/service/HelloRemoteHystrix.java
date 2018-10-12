package com.xd.eureka.service;


import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements FeignClientI {
    @Override
    public String hello() {
        return "熔断器，熔断";
    }
}
