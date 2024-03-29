package com.zyj.springcloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理限流方式二
 * 实现限流接口统一处理
 */
@Component
public class BlockHandler2 implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        System.out.println("BlockExceptioonHandler ++++++++++++++++++++++++++"+e.getRule());

        Map<Integer,String> hashMap=new HashMap<>();

        if(e instanceof FlowException){
            hashMap.put(100,"接口限流了");
        }else if(e instanceof DegradeException){
            hashMap.put(101,"服务降级了");
        }else if(e instanceof ParamFlowException){
            hashMap.put(102,"热点参数限流了");
        }else if(e instanceof SystemBlockException){
            hashMap.put(103,"触发系统保护规则了");
        }else if(e instanceof AuthorityException){
            hashMap.put(104,"授权规则不通过");
        }

        //返回json数据
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(),hashMap);

    }
}
