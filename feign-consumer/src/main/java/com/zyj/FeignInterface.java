package com.zyj;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 声明一个feign客户端，请求的服务是feign-provider，请求的方法是hello，失败的回调是FeignFallbackService的toHello方法
 */
@FeignClient(value = "feign-provider",fallback = FeignFallbackService.class)
public interface FeignInterface {

    @GetMapping("/hello")
    String toHello();
}
