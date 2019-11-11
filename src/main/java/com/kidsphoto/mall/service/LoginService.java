package com.kidsphoto.mall.service;

import com.kidsphoto.mall.pojo.ResponseResult;

/**
 * @author 李明
 * @create 2019-11-11 13:40
 */

public interface LoginService {

    ResponseResult login(String password, String school);
}
