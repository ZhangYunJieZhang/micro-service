package com.zyj.alldemo.template;

/**
 * 模板方法抽象类（以做蛋糕为例）
 */
public abstract class CakeAbstract {

    //模板方法，一般是final不允许修改，定义的是不变的执行流程
    public final void templateMethod(){
        this.start();
        this.cakeBlank();
        if(this.isCream()){
            this.cream();
        }
        this.decorate();
    }

    //基本方法-具体方法
    public void start(){
        System.out.println("开始制作蛋糕");//不变的流程
    }

    //基本方法-具体方法
    public void cakeBlank(){
        System.out.println("制作蛋糕坯");//不变的流程
    }

    //基本方法-抽象方法
    public abstract void cream();//抹奶油，留着子类个性化修改

    //基本方法-抽象方法
    public abstract void decorate();//装饰蛋糕，留着子类个性化修改

    //基本方法-钩子方法
    public boolean isCream(){
        //是否要加奶油，也可以给子类覆盖重写，默认添加奶油
        return true;
    }
}
