package com.zyj.alldemo.observer.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 观察者实现这个接口，会自动找ApplicationListener的子类注册到spring
 */
@Component
public class EmailApplicationListener implements ApplicationListener<MsgEntity> {

    @Override
    public void onApplicationEvent(MsgEntity msgEntity) {
        System.out.println("发送邮件");
    }
}
