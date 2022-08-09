package com.zyj.alldemo.observer.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 其实就是观察者接口的实现
 */
@Component
public class WxApplicationListener implements ApplicationListener<MsgEntity> {

    @Override
    public void onApplicationEvent(MsgEntity msgEntity) {
        System.out.println("发送微信小程序消息");
    }
}
