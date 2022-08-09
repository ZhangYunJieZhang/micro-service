package com.zyj.alldemo.chainofresponsibleity;

public abstract class GatewayFilterAbstract {

    GatewayFilterAbstract gatewayFilterAbstract;

    /**
     * 抽象父类定义构造方法，子类就必须调用父类的构造方法先初始化父类（因为抽象类自己不能被初始化）
     * 如果使用方法二，其实就不用定义下一个节点这种变量了
     * @param gatewayFilterAbstract
     */
    public GatewayFilterAbstract(GatewayFilterAbstract gatewayFilterAbstract){
        this.gatewayFilterAbstract = gatewayFilterAbstract;
    }

    abstract void doFilter();

    abstract void doFilter(Object params, FilterChain filterChain);
}
