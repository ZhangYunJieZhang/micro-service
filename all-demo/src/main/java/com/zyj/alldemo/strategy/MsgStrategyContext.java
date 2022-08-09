package com.zyj.alldemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送短信策略上下文，用于获取具体渠道
 */
@Component
public class MsgStrategyContext {

    @Autowired
    SpringUtil springUtil;

    //根据策略id获取具体策略，一般策略id放beanname容易被攻击，可以搞个别名，正常是根据策略ID、策略名称、策略bean、策略类型等维护到表里，实现灵活配置
    MessageStrategy getMsgStrategy(String strategyId){
        return (MessageStrategy)springUtil.getBeanByName(strategyId);
    }

    //如果没有几个类且变化不大，感觉上面定义一个map来放具体策略实现也可以，不用一定放表中，只是没有表灵活
}
