package com.zyj.alldemo.template;

/**
 * 蛋糕B
 */
public class CakeB extends CakeAbstract {

    @Override
    public void cream() {
        System.out.println("添加植物奶油");
    }

    @Override
    public void decorate() {
        System.out.println("装饰12朵花");
    }

    public boolean isCream(){//重写钩子方法，制作蛋糕不添加奶油
        return false;
    }
}
