package com.github.cundream.eurekaconsumerfeign.controller;

import com.github.cundream.eurekaconsumerfeign.api.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    private HelloClient helloClient;

    @GetMapping("/consumer")
    public String hello() {
        return helloClient.consumer();
    }
}
