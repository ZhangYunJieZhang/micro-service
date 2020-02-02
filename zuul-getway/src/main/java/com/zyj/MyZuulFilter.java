package com.zyj;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul过滤器
 */
public class MyZuulFilter extends ZuulFilter {

    /**
     * 过滤类型
     * pre可以在请求被路由之前调用
     * route路由请求时被调用
     * post在routing和error过滤器之后被调用
     * error处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否执行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 包含过滤功能
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String method = httpServletRequest.getMethod();
        String url = httpServletRequest.getRequestURL().toString();
        System.out.printf("%s request to %s",method,url);
        return null;
    }
}
