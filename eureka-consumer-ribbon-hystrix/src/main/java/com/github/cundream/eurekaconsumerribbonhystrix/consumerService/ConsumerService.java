package com.github.cundream.eurekaconsumerribbonhystrix.consumerService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @auther : lc
 * @Date: 2019/1/24 09:35
 * @Description:
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return restTemplate.getForObject("http://eureka-client/hello", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}
