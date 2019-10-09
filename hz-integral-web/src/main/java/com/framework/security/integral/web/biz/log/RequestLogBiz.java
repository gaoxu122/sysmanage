package com.framework.security.integral.web.biz.log;


import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.log.http.HttpRequestContext;
import com.framework.security.integral.core.dao.log.RequestLogMapper;
import com.framework.security.integral.core.model.log.RequestLog;
import com.framework.security.integral.web.intercepter.ControllerLogAop;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 请求日志业务类
 *
 * @author gaoxu
 * @create 2019/4/1 11:42
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class RequestLogBiz extends BaseBiz<RequestLogMapper, RequestLog> {

    /**
     * 创建请求日志
     *
     * @param joinPoint
     * @param httpRequestContext
     * @param status
     */
    public void createRequestLog(JoinPoint joinPoint, HttpRequestContext httpRequestContext, boolean status) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        long rt = System.currentTimeMillis() - httpRequestContext.getStartTime();
        RequestLog requestLogDO = new RequestLog();


        requestLogDO.setClassName(className);
        requestLogDO.setMethodName(methodName);
        requestLogDO.setClientIp(httpRequestContext.getClientIp());
        requestLogDO.setCookies(httpRequestContext.getCookies());
        requestLogDO.setRequestUri(httpRequestContext.getRequestURI());
        requestLogDO.setRequestUrl(httpRequestContext.getRequestURL());
        requestLogDO.setRt(rt);
        requestLogDO.setRequestMethod(httpRequestContext.getRequestMethod());
        requestLogDO.setQuery(ControllerLogAop.getParmsList(joinPoint).toString());
        requestLogDO.setStartTime(new Date(httpRequestContext.getStartTime()));
        requestLogDO.setEndTime(new Date());
        requestLogDO.setStatus(status);

        requestLogDO.setGmtCreate(new Date());
        this.insert(requestLogDO);
    }

}
