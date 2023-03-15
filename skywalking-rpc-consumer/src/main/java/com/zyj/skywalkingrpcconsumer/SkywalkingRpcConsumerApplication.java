package com.zyj.skywalkingrpcconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SkywalkingRpcConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkywalkingRpcConsumerApplication.class, args);
    }

}
