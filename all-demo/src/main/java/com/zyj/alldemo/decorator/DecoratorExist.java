package com.zyj.alldemo.decorator;

import java.lang.annotation.*;

/**
 * 装饰模式的进阶：自定义注解实现装饰（搭配AOP或者自己搞反射都可以）
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)//使用反射时获取信息可以获取到这个注解
@Target(value = {ElementType.METHOD,ElementType.TYPE})//可以作用于了方法和类上面
public @interface DecoratorExist {

    String value() default "test";//注解上可以value=XXX
}
