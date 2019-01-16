package com.github.cundream.eurekaconsumerribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther : lc
 * @Date: 2018/12/25 10:56
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String hello() {
        System.out.println("eureka-consumer-ribbon");
        return restTemplate.getForObject("http://eureka-client/hello", String.class);
    }
}
