package com.zyj.gatewayoauth.controller;

import com.zyj.gatewayoauth.entity.GatewayEntity;
import com.zyj.gatewayoauth.service.MyGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGatewayController {

    @Autowired
    private MyGatewayService gatewayService;

    @RequestMapping("/syncRoute")
    public String syncRoute(){
        GatewayEntity gatewayEntity = new GatewayEntity();
        gatewayEntity.setRouteId("11");
        gatewayEntity.setRouteName("测试http方法转发到百度");
        gatewayEntity.setPridicate("/payservice/**");
        gatewayEntity.setRouteType("1");
        gatewayEntity.setUrl("https://www.baidu.com");
        return gatewayService.loadRoute(gatewayEntity);
    }
}
