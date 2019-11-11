package com.kidsphoto.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李明
 * @create 2019-11-07 10:36
 */

@RestController
@Slf4j
@Api(value = "用户登录controller", tags = "用户登录接口")
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口")
    public ResponseResult login(@RequestBody JSONObject jsonObject) {

        String password = jsonObject.getString("password");
        String school = jsonObject.getString("school");
        try {
            ResponseResult result = this.loginService.login(password, school);
            return  result;
        } catch (Exception e) {
           log.info("【登录接口】出现错误：" + e.getMessage());
            return ResponseResult.fail(e.getMessage());
        }
    }


}
