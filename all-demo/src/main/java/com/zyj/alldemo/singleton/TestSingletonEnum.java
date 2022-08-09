package com.zyj.alldemo.singleton;

public class TestSingletonEnum {

    public static void main(String[] args){
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        singletonEnum1.say();
        System.out.println(singletonEnum1 == singletonEnum2);
    }
}
