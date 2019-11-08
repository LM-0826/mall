package com.kidsphoto.mall.interceptor;

import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李明
 * @create 2019-11-08 13:22
 */
@Component
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String[] IGNORE_URL = {"/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getServletPath();
        String token = request.getHeader("LoginToken");
        log.info("【请求进入LoginInterceptor，请求地址{}，请求的token{}】", path, token);
        for (String ignoreUrl : IGNORE_URL) {
            if (path.startsWith(ignoreUrl)) {
                return true;
            }
        }

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
//TODO token 验证


        printResponse(response);
        return false;
    }

    private void printResponse(HttpServletResponse response) {
        // 将实体对象转换为JSON Object转换
        String json = JsonUtils.objectToJson(ResponseResult.build(50001, "token验证失败"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.setStatus(HttpStatus.OK.value());
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
