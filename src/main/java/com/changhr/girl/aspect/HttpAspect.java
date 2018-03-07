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

        logger.info("log: before AOP!");

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url = {}",request.getRequestURL());

        //Request Method
        logger.info("request Method = {}",request.getMethod());

        //ip address
        logger.info("ip address = {}",request.getRemoteAddr());

        //类方法
        logger.info("Class Method = {}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("Arguments = {}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("log: after AOP!");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response = {}",object.toString());
    }
}
