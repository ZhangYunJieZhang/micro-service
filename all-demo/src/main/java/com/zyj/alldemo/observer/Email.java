package com.zyj.alldemo.observer;

import org.springframework.stereotype.Component;

@Component
public class Email implements MsgObserver {

    @Override
    public String send() {

        System.out.println("发送邮件方法执行");
        return "邮件";
    }
}
