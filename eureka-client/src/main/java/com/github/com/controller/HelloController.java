package com.github.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther : lc
 * @Date: 2018/12/25 10:32
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
