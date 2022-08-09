package com.zyj.alldemo.observer;

/**
 * 观察者模式的观察者接口，也可以是抽象类
 */
public interface MsgObserver {

    //定义发消息方法
    String send();
}
