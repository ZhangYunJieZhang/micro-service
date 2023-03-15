package com.zyj.springbootloki.aspect;

import com.alibaba.fastjson.JSONObject;
import com.zyj.springbootloki.LokiLabelType;
import com.zyj.springbootloki.annotation.LokiLabel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * loki打标签注解实现
 */
@Aspect
@Slf4j
@Component
public class LokiAspect {

    /**
     * 切到所有OperatorLog注解修饰的方法
     */
    @Pointcut("@annotation(com.zyj.springbootloki.annotation.LokiLabel)")
    public void operatorLog() {
        // 空方法
    }

    /**
     * 利用@Around环绕增强
     *
     * @return
     */
    @Around("operatorLog()")
    public synchronized Object around(ProceedingJoinPoint pjp) throws Throwable {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        HttpServletResponse response = attributes.getResponse();

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        LokiLabel lokiLabel = method.getAnnotation(LokiLabel.class);

        // 获取描述信息
        LokiLabelType lokiLabelType = lokiLabel.type();

        MDC.put("log_file_type", lokiLabelType.getDesc());
        log.info("输入参数：" + JSONObject.toJSONString(pjp.getArgs()));

        Object proceed = pjp.proceed();

        log.info("返回参数：" + JSONObject.toJSONString(proceed));
        MDC.remove("log_file_type");
        return proceed;

    }

}
