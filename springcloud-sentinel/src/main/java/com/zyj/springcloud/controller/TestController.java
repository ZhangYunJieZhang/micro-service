package com.zyj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zyj.springcloud.handler.BlockHandler1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * sentinel控制面板会的簇点链路会自动生成一个名为hello的链路，名字唯一即可
     * 自定义限流处理类BlockHandler1，和处理方法helloBlock，也可以实现BlockExceptionHandler接口统一处理限流
     * @SentinelResource注解如果和BlockExceptionHandler接口实现同时存在，注解的优先级更高
     * @return
     */
    @GetMapping("/hello")
    //@SentinelResource(value = "hello", blockHandlerClass = BlockHandler1.class, blockHandler = "helloBlock")
    public String helloWorld(){
        return "hello zyj";
    }
}
