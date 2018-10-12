package com.xd.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-provider", fallback = HelloRemoteHystrix.class)
public interface FeignClientI {
    @RequestMapping(value = "/feignServer")
    public String hello();
}
