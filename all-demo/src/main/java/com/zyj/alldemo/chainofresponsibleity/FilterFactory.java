package com.zyj.alldemo.chainofresponsibleity;

/**
 * 使用方法三，提供工厂类从数据库读取整个责任链的链路顺序
 */
public class FilterFactory {

    //获取责任链第一个节点（基于数据库可灵活配置的模式）
    public GatewayFilterAbstract getFirstFilter(){
        //获取第一个节点
        GatewayFilterAbstract first = null;
        //调用SpringUtil.getBean获取当前节点对象

        //递归设置下一个节点
        GatewayFilterAbstract temp = first;
        while("有下一个节点".equals("temp有下一个节点")){
            //调用SpringUtil.getBean获取下一个节点对象
            GatewayFilterAbstract next = null;
            //数据库获取下一个
            temp = next;
        }
        return first;
    }
}
