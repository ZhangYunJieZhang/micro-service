package com.zyj.alldemo.spi.run;

import com.zyj.alldemo.spi.api.TestSpi;

import java.util.ServiceLoader;

/**
 * 测试spi机制加载类，破坏双亲委派机制,直接从应用类加载器中读取，不会执行loadservice方法去找父加载器
 */
public class RunTestSpi {

    public static void main(String[] args){
        ServiceLoader<TestSpi> services = ServiceLoader.load(TestSpi.class);
        services.forEach(t ->System.out.println(t.sayHello()));
    }
}
