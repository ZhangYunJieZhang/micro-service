package com.zyj.springbootloki.controller;

import com.zyj.springbootloki.LokiLabelType;
import com.zyj.springbootloki.annotation.LokiLabel;
import com.zyj.springbootloki.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    ITestService testService;

    /**
     * 加在controller的话就是代表从请求入口开始上标签，直至整个调用链路结束，加在service的话就是从service开始
     */
    @LokiLabel(type = LokiLabelType.B)
    @GetMapping("/hello")
    public void sayHello(){
        //方法一，不用注解手动给请求方法打标签
        //MDC.put("log_file_type", "test_label1");
        log.info("这是controller日志");
        log.info("随便一行日志用于测试根据关键字搜索的效果");
        testService.sayHello();
        //MDC.remove("log_file_type");
    }
}
