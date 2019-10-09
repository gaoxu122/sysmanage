package com.framework.security.integral.web.biz.log;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.log.http.HttpRequestContext;
import com.framework.security.integral.core.dao.log.ExceptionLogMapper;
import com.framework.security.integral.core.model.log.ExceptionLog;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author gaoxu
 * @date 2019-07-08 16:24
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ExceptionLogBiz extends BaseBiz<ExceptionLogMapper, ExceptionLog> {

    /**
     * 记录异常日志
     *
     * @param joinPoint
     * @param throwable
     * @param httpRequestContext
     */
    public void createExceptionLog(JoinPoint joinPoint, Throwable throwable, HttpRequestContext httpRequestContext) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        ExceptionLog exceptionLogDO = new ExceptionLog();

        exceptionLogDO.setClientIp(httpRequestContext.getClientIp());
        exceptionLogDO.setClassName(className);
        exceptionLogDO.setMethodName(methodName);
        String msg = throwable.getMessage();
        exceptionLogDO.setRequestMethod(httpRequestContext.getRequestMethod());
        exceptionLogDO.setExceptionType(throwable.toString());
        exceptionLogDO.setExceptionMsg(throwable.getMessage());
        exceptionLogDO.setIsView(false);
        exceptionLogDO.setExceptionTime(new Date());
        exceptionLogDO.setGmtCreate(new Date());
        this.insert(exceptionLogDO);
    }
}
