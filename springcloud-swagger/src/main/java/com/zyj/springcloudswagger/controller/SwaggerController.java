package com.zyj.springcloudswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试swager直接测试前后端分离接口
 */
@RestController
@Api(value = "用户模块API")
public class SwaggerController {

    @GetMapping("/getUser")
    @ApiOperation(value = "根据姓名获取用户", notes = "接口发布说明" , httpMethod = "GET" , response = String.class)
    @ApiParam(value = "只传一个用户姓名就可以" , name = "用户姓名" , required = true)
    public String getUser(String userName){
        return "hello" + userName;
    }
}
