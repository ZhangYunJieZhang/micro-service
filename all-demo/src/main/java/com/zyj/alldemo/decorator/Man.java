package com.zyj.alldemo.decorator;

/**
 * 需要被增强的类
 */
public class Man extends DecoratorAbstract {

    @Override
    void say() {
        System.out.println("被增强类的方法执行");
    }
}
