package com.zyj.alldemo.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 观察者模式的注册中心（可以先定义接口和抽象类，这里直接类也行）
 */
@Component
public class MsgSubject {

    //方法二，spring会主动注入所有MsgObserver
    @Autowired
    Map<String, MsgObserver> allObserver2;

    //方法一，定义RegisterObserver类实现ApplicationRunner接口在spring项目启动后自行注入Map中
    Map<String, MsgObserver> allObserver = new ConcurrentHashMap<>();

    ExecutorService executors = Executors.newFixedThreadPool(10);

    //通知全部观察者
    void notifyAllObserver(){
        for(String key : allObserver.keySet()){
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    allObserver.get(key).send();
                }
            });
        }
    }

    //添加观察者
    void addObserver(MsgObserver msgObserver){
        allObserver.put("获取类名再把首字母小写，或者不用map接收用list其实最好，只是弄成map对比自动注入的", msgObserver);
    }
}
