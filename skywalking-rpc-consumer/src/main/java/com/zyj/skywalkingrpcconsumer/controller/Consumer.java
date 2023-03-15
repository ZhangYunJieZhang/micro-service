package com.zyj.skywalkingrpcconsumer.controller;

import com.zyj.skywalkingrpcconsumer.feign.SkyWalkingProducerFeign;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Consumer {

    @Autowired
    SkyWalkingProducerFeign producerFeign;

    @RequestMapping("/call")
    public String call() throws Exception {
        String traceId = TraceContext.traceId();
        log.info("请求方法：call，全局跟踪id：{}", traceId);
        ActiveSpan.tag("消费端tag", "111");
        Thread.sleep(3000);
        return producerFeign.hello();
    }

    @PostMapping("/notify")
    public void notify(Object o){
        log.info("收到服务告警:{}", o.toString());
    }
}
