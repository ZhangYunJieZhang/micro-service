package com.zyj.alldemo.singleton;

import java.io.Serializable;

/**
 * 饿汉单例模式
 */
public class SingletonHunger implements Serializable {

    private static SingletonHunger singletonHunger;

    //私有化无参构造函数
    private SingletonHunger() throws Exception {
        if(singletonHunger != null){
            throw new Exception("已经初始化过，请不要尝试反射破解");
        }else{
            singletonHunger = this;//主要为了防止先通过反射获取对象后，再调用getInstance方法重复创建
        }
    }

    //获取同一个实例
    static SingletonHunger getInstance() throws Exception {
        //双重判断保证单例
        if(singletonHunger == null){
            synchronized (SingletonHunger.class){
                if(singletonHunger == null){
                    singletonHunger = new SingletonHunger();
                }
            }
        }
        return singletonHunger;
    }

    //序列化获取对象其实会回调这个方法获取单例，没有这个方法就层层往上找父类且没有实现Serializable的无参构造函数创建父类对象，至于这个对象最后怎么转成Singletonhunger还不知道
    public Object readResolve(){
        return singletonHunger;
    }

}
