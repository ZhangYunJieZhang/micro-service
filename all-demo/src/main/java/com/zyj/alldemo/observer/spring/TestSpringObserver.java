package com.zyj.alldemo.observer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试spring自带的观察者模式
 */
@RestController
public class TestSpringObserver {

    //publishEvent就是循环调用每个观察者的方法，但是是同步的，想要异步还得在观察者方法上加个@Async
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        MsgEntity msgEntity = new MsgEntity(this);
        applicationEventPublisher.publishEvent(msgEntity);
        return "success";
    }
}
