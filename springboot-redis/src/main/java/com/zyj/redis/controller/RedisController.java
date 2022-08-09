package com.zyj.redis.controller;

import com.alibaba.fastjson.JSON;
import com.zyj.redis.bean.UserEntity;
import com.zyj.redis.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RedisController {

    @Autowired
    RedisCacheUtil redisCacheUtil;

    @GetMapping("/setUser")
    public String setUser(UserEntity userEntity){
        redisCacheUtil.setValue(userEntity.getUserId(), JSON.toJSONString(userEntity));
        return "true";
    }

    @RequestMapping("/getUser")
    public String getUser(@RequestParam String userId){
        return redisCacheUtil.getValue(userId);
    }

    @GetMapping("/setUser2")
    public String setUser2(UserEntity userEntity){
        redisCacheUtil.setObject(userEntity.getUserId(), userEntity);
        return "true";
    }

    @RequestMapping("/getUser2")
    public Object getUser2(@RequestParam String userId){
        return redisCacheUtil.getObject(userId);
    }

    /**
     * 测试redis缓存，启动类需要开启缓存
     * 而且key的单引号不能少，少了会报错
     * cacheNames和key可以理解为文件夹的层级关系
     * @return
     */
    @RequestMapping("/getAllUser")
    @Cacheable(cacheNames = "Alluser" , key = "'getAllUser'")
    public List<UserEntity> getAllUser(){
        //实际应该查询数据库，这里省了，目的反正为了缓存当次查询结果
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("123456");
        userEntity.setUserName("赵柳");
        List users = new ArrayList();
        users.add(userEntity);
        return users;
    }

}
