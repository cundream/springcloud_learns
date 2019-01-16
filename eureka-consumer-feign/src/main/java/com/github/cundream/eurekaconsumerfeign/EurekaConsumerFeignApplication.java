package com.github.cundream.eurekaconsumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @auther : lc
 * @Date: 2018/12/28 10:21
 * @Description:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeignApplication.class, args);
    }
}
