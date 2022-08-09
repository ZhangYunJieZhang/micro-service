package com.zyj.alldemo.chainofresponsibleity;

/**
 * 测试用例
 */
public class TestChain {

    public static void main(String[] args){
        //使用方法一，自己需要设定每条链路的调用先后顺序，比较麻烦
        BlackGatewayFilter blackGatewayFilter = new BlackGatewayFilter(null);
        IpGatewayFilter ipGatewayFilter = new IpGatewayFilter(blackGatewayFilter);
        LimitGatewayFilter limitGatewayFilter = new LimitGatewayFilter(ipGatewayFilter);
        limitGatewayFilter.doFilter();
    }

    public static void main2(String[] args){
        //使用方法二，这种方式就是执行顺序就是添加的顺序了，不过思路filterChain.doFilter方法值得借鉴
        FilterChain filterChain = new FilterChain();
        BlackGatewayFilter blackGatewayFilter = new BlackGatewayFilter(null);
        IpGatewayFilter ipGatewayFilter = new IpGatewayFilter(null);
        LimitGatewayFilter limitGatewayFilter = new LimitGatewayFilter(null);
        filterChain.addFilter(blackGatewayFilter);
        filterChain.addFilter(ipGatewayFilter);
        filterChain.addFilter(limitGatewayFilter);
        filterChain.doFilter("", filterChain);
    }
}
