package com.github.cundream.eurekafeignuploadclient.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther : lc
 * @Date: 2018/12/28 15:19
 * @Description:
 */
@Configuration
public class MultipartSupportConfig {
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
