package com.zyj.alldemo.decorator;

public class TestDecorator {

    public static void main(String[] args){
        //原方法调用
        DecoratorAbstract man = new Man();
        man.say();
        //使用增强后调用
        DecoratorAbstract superMan = new SuperMan(man);
        superMan.say();
    }
}
