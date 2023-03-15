package com.zyj.sleuthzipkinserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestSleuthZipkinServer {

    @RequestMapping("/sayHelloToServer")
    public String testRequest(String name){
        log.info("微服务2收到请求");
        return "service2 say hello, " + name;
    }
}
