package com.zyj.sleuthzipkin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("sleuth-zipkin-server")
public interface SleuthZipkinServerFeign {

    @RequestMapping("/sayHelloToServer")
    String call(String name);

}
