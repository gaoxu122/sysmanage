package com.framework.security.integral.web.intercepter;

/**
 * @author jianghx
 * @create 2019/4/2 13:50
 **/


import com.framework.security.integral.web.biz.log.ExceptionLogBiz;
import com.framework.security.integral.web.biz.log.RequestLogBiz;
import com.framework.security.integral.common.log.format.LogFormatter;
import com.framework.security.integral.common.log.http.HttpRequestContext;
import com.framework.security.integral.common.log.http.HttpRequestContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Slf4j
public class ControllerLogAop {

    private final static Logger mainLogger = LoggerFactory.getLogger(ControllerLogAop.class);
    private final static Logger bizLogger = LoggerFactory.getLogger("CONTROLLER_PROFILE_LOG");


    @Autowired
    private HttpRequestContextHolder httpRequestContextHolder;


    @Autowired
    private ExceptionLogBiz exceptionLogBiz;

    @Autowired
    private RequestLogBiz requestLogBiz;


    @Pointcut("execution(* com.framework.security.integral.*.controller..*(..))")
    public void pointCut() {

    }

    /**
     * 调用前
     *
     * @param
     * @return
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Throwable {

        HttpRequestContext httpRequestContext = httpRequestContextHolder.getHttpRequestContext();
        log.debug(LogFormatter.getKVLogData(LogFormatter.LogEvent.START,
                LogFormatter.KeyValue.getNew("clientIp", httpRequestContext.getClientIp()),
                LogFormatter.KeyValue.getNew("requestMethod", httpRequestContext.getRequestMethod()),
                LogFormatter.KeyValue.getNew("requestURI", httpRequestContext.getRequestURI()),
                LogFormatter.KeyValue.getNew("requestURL", httpRequestContext.getRequestURL()),
                LogFormatter.KeyValue.getNew("query", httpRequestContext.getQuery()),
                LogFormatter.KeyValue.getNew("rt", System.currentTimeMillis() - httpRequestContext.getStartTime())
        ));


    }


    @After("pointCut()")
    public void after(JoinPoint joinPoint) {

        HttpRequestContext httpRequestContext = httpRequestContextHolder.getHttpRequestContext();
        log.debug(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                LogFormatter.KeyValue.getNew("clientIp", httpRequestContext.getClientIp()),
                LogFormatter.KeyValue.getNew("requestMethod", httpRequestContext.getRequestMethod()),
                LogFormatter.KeyValue.getNew("requestURI", httpRequestContext.getRequestURI()),
                LogFormatter.KeyValue.getNew("requestURL", httpRequestContext.getRequestURL()),
                LogFormatter.KeyValue.getNew("query", httpRequestContext.getQuery()),
                LogFormatter.KeyValue.getNew("rt", System.currentTimeMillis() - httpRequestContext.getStartTime())
        ));
        log.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.TIME,
                LogFormatter.KeyValue.getNew("耗时", System.currentTimeMillis() - httpRequestContext.getStartTime())
        ));

    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        HttpRequestContext httpRequestContext = httpRequestContextHolder.getHttpRequestContext();
        boolean status = true;
//        createRequestLog(joinPoint, httpRequestContext, status);
//        deconnexionLogBiz.insertDeconnexion(joinPoint, httpRequestContext, status);
/*
        String[] urls = {
                "/user/**",
                "/dict/**",
        };
        //放过钉钉事件注册回调接口
        if(result instanceof  BaseResponse||"/api/event/check".equals(httpRequestContext.getRequestURI())){


        }else{
            throw  new ResponseResultException(ServiceResultCode.FRAMEWORK_RESPONSE_RESULT_ERROR.getMsg(),ServiceResultCode.FRAMEWORK_RESPONSE_RESULT_ERROR.getCode());
        }*/


    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        HttpRequestContext httpRequestContext = httpRequestContextHolder.getHttpRequestContext();
        boolean status = false;
        // 记录请求失败日志
        requestLogBiz.createRequestLog(joinPoint, httpRequestContext, status);
        // 记录异常日志
        exceptionLogBiz.createExceptionLog(joinPoint, throwable, httpRequestContext);
    }


    /**
     * 获取请求参数
     *
     * @param joinPoint
     * @return
     */
    public static List<Object> getParmsList(JoinPoint joinPoint) {
        List<Object> parmsList = new ArrayList<Object>();
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            if (signature != null && joinPoint.getArgs() != null) {
                Method method = signature.getMethod();
                Annotation[][] methodAnnotations = method.getParameterAnnotations();
                Object[] argArr = joinPoint.getArgs();
                parmsList = Arrays.asList(argArr);
            }
        } catch (Exception e) {
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    "parse parms error"
            ), e);
        }

        return parmsList;
    }

}
