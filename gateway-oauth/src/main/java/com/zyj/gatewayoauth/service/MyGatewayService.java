package com.zyj.gatewayoauth.service;

import com.zyj.gatewayoauth.entity.GatewayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 路由的动态增删改
 */
@Service
public class MyGatewayService implements ApplicationEventPublisherAware {

    @Autowired
    RouteDefinitionWriter routeDefinitionWriter;

    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public String loadAllRoute(){
        //正常是要查询数据库然后循环调用loadRoute方法

        return "success";
    }

    public String loadRoute(GatewayEntity gatewayEntity){
        RouteDefinition routeDefinition = new RouteDefinition();
        Map<String,String> predicateParams = new HashMap<>(8);
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        FilterDefinition filterDefinition = new FilterDefinition();
        Map<String,String> filterParams = new HashMap<>();
        URI uri;
        if("0".equals(gatewayEntity.getRouteType())){
            uri = UriComponentsBuilder.fromUriString(gatewayEntity.getUrl()+"/").build().toUri();
        }else{
            uri = UriComponentsBuilder.fromHttpUrl(gatewayEntity.getUrl()).build().toUri();
        }
        //定义路由id
        routeDefinition.setId(gatewayEntity.getRouteId());
        predicateDefinition.setName("Path");
        //路由转发地址
        predicateParams.put("pattern",gatewayEntity.getPridicate());
        predicateDefinition.setArgs(predicateParams);
        //名称是固定的，路劲去除前缀
        filterDefinition.setName("StripPrefix");
        filterParams.put("_genkey_0","1");
        filterDefinition.setArgs(filterParams);

        routeDefinition.setPredicates(Arrays.asList(predicateDefinition));
        routeDefinition.setFilters(Arrays.asList(filterDefinition));
        routeDefinition.setUri(uri);

        //调用spring封装好的api直接发布
        routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
        return "success";
    }
}
