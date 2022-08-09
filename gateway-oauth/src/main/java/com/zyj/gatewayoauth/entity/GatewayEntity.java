package com.zyj.gatewayoauth.entity;

import lombok.Data;

/**
 * 路由实体类
 */
@Data
public class GatewayEntity {

    //路由Id
    String routeId;
    //路由名称
    String routeName;
    //断言或者叫路由规则 如：/payservice/**
    String pridicate;
    //路由类型 0通过配置中心转发 1直接http转发
    String routeType;
    //转发的url 如：lb://payservice或者http://xxxxxx
    String url;

}
