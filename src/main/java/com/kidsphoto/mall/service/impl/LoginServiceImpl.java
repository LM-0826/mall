package com.kidsphoto.mall.service.impl;

import com.kidsphoto.mall.dao.UserRepository;
import com.kidsphoto.mall.entity.User;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 李明
 * @create 2019-11-11 13:41
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepos;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseResult login(String password, String school) {

        User user = userRepos.findByPasswordAndSchool(password, school);
        if (user != null) {
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set("user_" + token , user.toString(), 24, TimeUnit.HOURS);
            return ResponseResult.ok(token);
        } else {
            return ResponseResult.fail();
        }
    }
}
