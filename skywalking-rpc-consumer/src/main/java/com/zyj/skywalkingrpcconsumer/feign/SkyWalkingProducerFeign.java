package com.zyj.skywalkingrpcconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("skywalking-rpc-producer")
public interface SkyWalkingProducerFeign {

    @RequestMapping("/hello")
    String hello();


}
