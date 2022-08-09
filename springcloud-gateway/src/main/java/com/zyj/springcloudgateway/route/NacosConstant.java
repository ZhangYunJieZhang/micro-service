package com.zyj.springcloudgateway.route;

import com.alibaba.nacos.api.PropertyKeyConst;

/**
 * nacos常量类，用于properties创建nacos的config，本例没有用到
 */
public class NacosConstant extends PropertyKeyConst {
    public static final String NACOS_SERVER_ADDR = "nacos.server-addr";

    public static final long DEFAULT_TIMEOUT = 30000;
}