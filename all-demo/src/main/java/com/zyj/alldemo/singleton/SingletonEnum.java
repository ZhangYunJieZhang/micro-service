package com.zyj.alldemo.singleton;

/**
 * 枚举类型的单例，天生就算序列化是单例且不可被反射
 */
public enum SingletonEnum {

    INSTANCE;

    void say(){
        System.out.println("单例方法被调用");
    }


    SingletonEnum(){
        System.out.println("枚举只会初始化一次，且构造函数不能加public");
    }
}
