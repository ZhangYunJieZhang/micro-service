package com.zyj.alldemo.decorator;

/**
 * 增强类
 */
public class SuperMan extends DecoratorAbstract {

    DecoratorAbstract decoratorAbstract;

    public SuperMan(DecoratorAbstract decoratorAbstract){
        this.decoratorAbstract = decoratorAbstract;
    }

    @Override
    void say() {
        System.out.println("此处执行方法增强");
        decoratorAbstract.say();
    }
}
