package com.zyj.alldemo.observer.spring;

import org.springframework.context.ApplicationEvent;

public class MsgEntity extends ApplicationEvent {

    public MsgEntity(Object source) {
        super(source);
    }
}
