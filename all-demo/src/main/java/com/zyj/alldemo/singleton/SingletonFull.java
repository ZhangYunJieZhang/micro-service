package com.zyj.alldemo.singleton;

/**
 * 饿汉单例模式
 *
 * 优点：先天性线程安全
 * 缺点：浪费jvm内存，单例都是直接放到永久代不会被回收
 */
public class SingletonFull {

    private final static SingletonFull singletonFull = new SingletonFull();

    //方法二
    //private static SingletonFull singletonFull = new SingletonFull();

    //私有化无参构造函数
    private SingletonFull(){

    }

    //方法二，在静态代码块中初始化，不过上面的变量不能用final了
    static{
        //singletonFull = new SingletonFull();
    }

    public static SingletonFull getInstance(){
        return singletonFull;
    }
}
