package com.zyj.alldemo.decorator;

/**
 * 装饰类的抽象方法，也可以是接口
 * 对外开放对内闭合这句话的意思感觉有点像因为是反向继承类，再通过内部成员去调用目标方法
 */
public abstract class DecoratorAbstract {

    //要被增强的抽象方法
    abstract void say();
}
