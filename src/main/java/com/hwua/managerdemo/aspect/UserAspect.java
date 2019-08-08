package com.hwua.managerdemo.aspect;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class UserAspect {

    private Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Pointcut("execution(public * com.hwua.managerdemo.controller.UserController.*(..))")
    public void log() {
    }

    //AOP前置通知
    @Before("log()")
    //JoinPoint：连接点，可以获取目标方法的信息
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //获取请求地址
        StringBuffer requestURL = request.getRequestURL();
        logger.debug("request url : {}", requestURL);
        //获取请求方式
        String method = request.getMethod();
        logger.debug("request methor : {}", method);
        //获取目标方法名
        String name = joinPoint.getSignature().getName();
        logger.debug("request name : {}", name);
        //获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        logger.debug("request args : {}", args);
    }

    //返回通知
    @AfterReturning(pointcut = "log()", returning = "object")
    public void afterReturning(Object object) {
        logger.debug("returning : {}", object);
    }

    //后置通知，在目标方法执行之后执行
    @After("log()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.debug("method {} end", name);
    }

    //异常通知，目标方法出现异常时执行
    @AfterThrowing(pointcut = "log()", throwing = "e")
    public void afterThrowing(Exception e) {
        logger.error("exception : {}", e.toString());
    }
}
