package com.zyj;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign是一个声明式的客户端调用工具，形式就是springMVC接口形式书写
 * 声明一个feign客户端，请求的服务是feign-provider，请求的方法是hello，失败的回调是FeignFallbackService的toHello方法
 *
 * 公司使用一般定义公共的接口，单独建立一个项目放接口
 *
 * public interface commonInterface{
 *
 *     @PostMappring("/hello")
 *     String hello(Stirng name);
 *
 * }
 *
 * 然后服务提供方去实现这个接口，并注册到注册中心，如euraka
 *
 * public Class commonInterfaceImpl implements commonInterface{
 *
 *     String hello(String name){
 *         return "hello" + name;
 *     }
 *
 * }
 *
 * 调用方想调用这个服务直接声明feign，其实就是通过接口和继承的方式抽离公共部分，防止代码重复
 * @FeignClient(value = "XXXX")
 * public interface extends commonInterface{
 *
 * }
 */


@FeignClient(value = "feign-provider",fallback = FeignFallbackService.class)
public interface FeignInterface {

    /**
     * 底层会自己使用rpc方式请求feign-provider的/hello
     * @return
     */
    @GetMapping("/hello")
    String toHello();
}
