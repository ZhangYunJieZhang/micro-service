package com.zyj.oauthresource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 为了启动api服务，先在资源中心写一个controller模拟一下
 */
@RestController
public class ResourceController {

    @RequestMapping("/payService")
    public String payService(){
        return "成功通过鉴权中心访问到支付服务";
    }
}
