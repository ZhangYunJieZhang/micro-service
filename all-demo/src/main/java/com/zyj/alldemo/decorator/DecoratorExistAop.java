package com.zyj.alldemo.decorator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 装饰类增强版
 * @Restcontroller(/say)
 * public void say(){
 *     man.say();-->一般装饰后需要手动变成superman.say()
 * }
 *
 * @Restcontroller(/say)
 * @DecoratorExist
 * public void say(){
 *     man.say();-->变成在aop中superman.say(),控制层的代码没变
 * }
 *
 */
@Component
@Aspect
@Slf4j
public class DecoratorExistAop {

    //注入装饰类
    @Autowired
    SuperMan superMan;

    @Around(value = "@annotation(com.zyj.alldemo.decorator.DecoratorExist)")
    public Object decoratorAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //这个其实就是在执行目标方法，这里可以不调用作为入参传递给方法
        //Object object = proceedingJoinPoint.proceed();
        //因此我们可以改一下say方法为say(proceedingJoinPoint)，然后就可以在say方法里头先增强再执行目标方法
        //当man.say()方法被调用的地方有这个自定义注解，就可以不手动改成superman.say()就实现增强
        //其实就是两种方式,要么使用装饰类去手动增强，要么这里去自动增强（其实就是手动调用的地方放这里了）
        //superMan.say(proceedingJoinPoint);
        //return object;
        return null;
    }
}
