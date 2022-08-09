package com.zyj.alldemo.lambda.service;

/**
 * @FunctionalInterface用于检测是不是函数接口
 */
@FunctionalInterface
public interface PayService {

    /**
     * z只允许一个抽象方法
     * @param money
     * @return
     */
    String pay(Integer money);

    /**
     * 可以添加由default修饰的普通方法
     */
    default void hello(){
        System.out.println("Hello World");
    }
}
