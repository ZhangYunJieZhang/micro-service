package com.zyj.alldemo.chainofresponsibleity;

public class IpGatewayFilter extends GatewayFilterAbstract {

    /**
     * 自己定义一个set方法去设置下一个责任链执行者也行，感觉没有这个方便
     * @param gatewayFilterAbstract
     */
    public IpGatewayFilter(GatewayFilterAbstract gatewayFilterAbstract) {
        super(gatewayFilterAbstract);
    }

    @Override
    void doFilter() {
        System.out.println("ip地址验证通过");
        if(gatewayFilterAbstract != null){
            gatewayFilterAbstract.doFilter();
        }
    }

    @Override
    void doFilter(Object params, FilterChain filterChain) {
        System.out.println("案例二，ip地址验证通过");
        filterChain.doFilter(params, filterChain);
    }
}
