package com.zyj.alldemo.template;

/**
 * 蛋糕A
 */
public class CakeA extends CakeAbstract {

    @Override
    public void cream() {
        System.out.println("添加动物奶油");
    }

    @Override
    public void decorate() {
        System.out.println("装饰六朵花");
    }
}
