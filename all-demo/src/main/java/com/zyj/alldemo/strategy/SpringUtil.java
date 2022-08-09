package com.zyj.alldemo.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //根据name获取bean
    public Object getBeanByName(String name){
        return applicationContext.getBean(name);
    }

    //根据Class获取bean
    public <T> T getBeanByClass(Class<T> t){
        return applicationContext.getBean(t);
    }
}
