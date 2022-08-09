package com.zyj.alldemo.observer;

import org.springframework.stereotype.Component;

@Component
public class Wx implements MsgObserver {

    @Override
    public String send() {

        System.out.println("发送小程序消息方法执行");
        return "小程序消息";
    }
}
