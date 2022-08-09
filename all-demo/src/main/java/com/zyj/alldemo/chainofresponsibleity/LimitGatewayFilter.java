package com.zyj.alldemo.chainofresponsibleity;

public class LimitGatewayFilter extends GatewayFilterAbstract {


    /**
     * 抽象父类定义构造方法，子类就必须调用父类的构造方法先初始化父类（因为抽象类自己不能被初始化）
     *
     * @param gatewayFilterAbstract
     */
    public LimitGatewayFilter(GatewayFilterAbstract gatewayFilterAbstract) {
        super(gatewayFilterAbstract);
    }

    @Override
    void doFilter() {
        System.out.println("限流校验通过");
        if(gatewayFilterAbstract != null){
            gatewayFilterAbstract.doFilter();
        }
    }

    @Override
    void doFilter(Object params, FilterChain filterChain) {
        System.out.println("案例二，限流校验通过");
        filterChain.doFilter(params, filterChain);
    }
}
