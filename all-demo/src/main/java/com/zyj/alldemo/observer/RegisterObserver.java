package com.zyj.alldemo.observer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * spring项目启动后会执行这个回调方法，这里添加观察者到注册中心可以保证全有类都是加载完毕的
 */
@Component
public class RegisterObserver implements ApplicationRunner, ApplicationContextAware {

    ApplicationContext applicationContext;

    @Autowired
    MsgSubject msgSubject;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //使用java反射获取MsgObserver下的子类，再注册到msgSubject
        Map<String, MsgObserver> allMsgObserver =  applicationContext.getBeansOfType(MsgObserver.class);
        for(String beanKey : allMsgObserver.keySet()){
            msgSubject.addObserver(allMsgObserver.get(beanKey));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
