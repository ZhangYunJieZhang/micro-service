package com.zyj.sleuthzipkin.controller;

import com.zyj.sleuthzipkin.feign.SleuthZipkinServerFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestSleuthZipkin {

    @Resource
    SleuthZipkinServerFeign serverFeign;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/sayHello")
    public String testRequest(String name){
        log.info("微服务1收到请求");
        return serverFeign.call("i am from service1,my name is " + name);
    }

    @RequestMapping("/sayHello2")
    public String testRequest2(String name){
        log.info("收到普通http请求");
        return "hello " + name;
    }

    @RequestMapping("/sayHello3")
    public String testRequest3(String name){
        log.info("收到普通http请求,准备发起额外请求");
        //随便测试再次请求zipkin有没有数据，不管成功失败
        return restTemplate.getForEntity("https://www.baidu.com", Object.class).toString();
    }

    @Bean
    public RestTemplate RestTemplate(){
        return new RestTemplate();
    }
}
