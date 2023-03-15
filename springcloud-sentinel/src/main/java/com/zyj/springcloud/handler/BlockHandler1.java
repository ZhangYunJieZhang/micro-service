package com.zyj.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * 处理限流方式一
 * 接口上用注解指定处理的类和方法
 */
@Component
public class BlockHandler1 {

    /**
     * 限流处理方法，必须是静态的
     * @param e
     * @return
     */
    public static String helloBlock(BlockException e){
        return "您被限流了";
    }
}
