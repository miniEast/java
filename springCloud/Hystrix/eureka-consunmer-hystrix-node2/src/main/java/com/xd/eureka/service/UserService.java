package com.xd.eureka.service;


import com.xd.eureka.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;//ribbon 负载均衡器


    public List<User> getUsers() {
        //  选择调用服务的名称
//        serviceInstance 封装了服务的基本信息包括ip地址
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");

//        拼接服务的访问的url   http://localhost:9090/users
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://").append(serviceInstance.getHost()).append(":").append(serviceInstance.getPort()).append("/users");

//        发送请求   springMVC RestTemplate
        RestTemplate restTemplate = new RestTemplate();
//        返回数据
        ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>(){

        };
//        返回值二次封装   restTemplate.exchange(url, 请求方式,请求参数,返回类型封装);
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(stringBuffer.toString(), HttpMethod.GET,null,type);

        List<User> userList = responseEntity.getBody();

         return userList;
    }
}
