package com.changhr.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tony on 2018/3/6.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.changhr.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //Method
        logger.info("method={}",request.getMethod());

        //ip address
        logger.info("ip address={}",request.getRemoteAddr());

        //类方法
        logger.info("class method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("arguments={}",joinPoint.getArgs());


        logger.info("Info: Before Pointcut log Method...");
    }

    @After("log()")
    public void doAfter(){
        logger.info("Info: After Pointcut log Method...");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
