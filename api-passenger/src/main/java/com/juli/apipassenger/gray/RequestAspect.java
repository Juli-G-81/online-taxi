package com.juli.apipassenger.gray;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Juli
 * @date ： 2023/3/2 4:05 PM
 * @description：
 * @modifiedBy ：
 * @version:
 */
@Aspect
@Component
public class RequestAspect {

    @Pointcut("execution(* com.juli.apipassenger.controller..*Controller*.*(..))")
    private void anyMehtod(){

    }

    @Before(value = "anyMehtod()")
    public void before(JoinPoint joinPoint){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String version = request.getHeader("version");

        Map<String,String> map = new HashMap<>();
        map.put("version",version);

        RibbonParameters.set(map);

    }
}
