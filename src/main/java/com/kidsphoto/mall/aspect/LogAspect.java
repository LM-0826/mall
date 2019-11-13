package com.kidsphoto.mall.aspect;

import com.kidsphoto.mall.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author 李明
 * @create 2019-11-07 10:32
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    private final static String SESSION_TOLEN_KEY = "sessionId";

    @Pointcut("execution(public * com.kidsphoto.mall.controller..*.*(..))")
    public void webLog() {

    }

    /**
     * 请求进来执行前记录日志
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            String sessionId = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
            MDC.put(SESSION_TOLEN_KEY,sessionId);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //记录请求内容
            String params = request.getQueryString() == null ? "" : "?" + request.getQueryString();
            String url = request.getRequestURL().toString() + params;
            String method = request.getMethod();
            String ip = request.getRemoteAddr();
            String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            StringBuilder args = new StringBuilder();
            for (Object arg : joinPoint.getArgs()) {
                System.out.println(arg.getClass());
                args.append("|");
                if (arg instanceof ServletRequest || arg instanceof ServletResponse) {
                    args.append("null").append("|");
                } else {
                    args.append(JsonUtils.objectToJson(arg)).append("|");
                }
            }
            System.out.println(args.toString());
            log.info("\n【请求URL：{}】\n【请求METHOD：{}】\n【请求者IP：{}】\n【调用类-方法：{}】\n【调用参数：{}】",url,method,ip,classMethod,args.toString());
        } catch (Exception e) {
            log.info("【方法调用前，产生异常】【异常信息{}】",e.getMessage());
        }
    }

    @After("webLog()")
    public void after(JoinPoint joinPoint) {
        MDC.remove(SESSION_TOLEN_KEY);
    }


}
