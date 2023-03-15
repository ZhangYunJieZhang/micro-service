package com.zyj.springbootloki.annotation;

import com.zyj.springbootloki.LokiLabelType;

import java.lang.annotation.*;

/**
 * loki日志标签注解，也可以不用标签，但是搜索麻烦
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
@Documented
public @interface LokiLabel {

    LokiLabelType type() default LokiLabelType.DEFAULT;
}
