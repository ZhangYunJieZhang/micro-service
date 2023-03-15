package com.zyj.skywalkingrpcproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Producer {

    @RequestMapping("/hello")
    public String hello(){
        String traceId = TraceContext.traceId();
        log.info("请求方法：hello，全局跟踪id：{}", traceId);
        ActiveSpan.tag("生产端tag", "222");
        return "hello, i am skywalking rpc producer";
    }
}
