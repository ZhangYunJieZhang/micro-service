package com.zyj.alldemo.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 单例模式测试类
 */
public class TestSingleton {

    public static void main(String[] args) throws Exception {

        SingletonHunger singletonHunger1 = SingletonHunger.getInstance();
        SingletonHunger singletonHunger2 = SingletonHunger.getInstance();
        System.out.println(singletonHunger1 == singletonHunger2);

        //测试java反射获取实例
        Class hungerClass = Class.forName("com.zyj.alldemo.singleton.SingletonHunger");
        Constructor constructor = hungerClass.getDeclaredConstructor();//hungerClass.getConstructor()连带父类的构造方法也会获取到
        constructor.setAccessible(true);
        //SingletonHunger singletonHunger3 = (SingletonHunger) constructor.newInstance();//因为已经修改了无参构造函数所以这里会报错
        //System.out.println(singletonHunger1 == singletonHunger3);

        //测试序列化获取实例
        FileOutputStream fileOutputStream = new FileOutputStream("D:/singleton.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(singletonHunger1);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:/singleton.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SingletonHunger singletonHunger4 = (SingletonHunger) objectInputStream.readObject();//这里其实会回调readResolve
        System.out.println(singletonHunger1 == singletonHunger4);
        objectInputStream.close();
        fileInputStream.close();
    }
}
