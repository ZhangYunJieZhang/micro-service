package com.zyj.alldemo.chainofresponsibleity;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用方法二，提供责任链核心类来封装调用顺序
 */
public class FilterChain {

    //全部责任链处理器
    List<GatewayFilterAbstract> filterAbstractList = new ArrayList<>();

    //处理节点下标
    int index = 0;

    //添加处理节点
    public FilterChain addFilter(GatewayFilterAbstract gatewayFilterAbstract){
        filterAbstractList.add(gatewayFilterAbstract);
        return this;
    }

    //执行责任链节点方法
    public void doFilter(Object params, FilterChain filterChain){
        if(index == filterAbstractList.size()){
            return;
        }
        GatewayFilterAbstract gatewayFilterAbstract = filterAbstractList.get(index);
        index ++;
        gatewayFilterAbstract.doFilter(params, filterChain);
    }

}
