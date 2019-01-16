package com.github.cundream.eurekaconsumerfeign.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: lc
 * @Date: 2018/12/28 10:26
 * @Description:
 */
@FeignClient("eureka-client")
public interface HelloClient {
    @GetMapping("/hello")
    String consumer();

}
