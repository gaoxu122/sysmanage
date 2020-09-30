package com.framework.security.integral.web.biz.log;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.context.BaseContextHandler;
import com.framework.security.integral.common.log.http.HttpRequestContext;
import com.framework.security.integral.core.dao.log.LoginLogMapper;
import com.framework.security.integral.core.model.log.LoginLog;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.genid.GenId;

/**
 * @author gaoxu
 * @date 2019-07-08 16:18
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginLogBiz extends BaseBiz<LoginLogMapper, LoginLog> {

    /**
     * 创建登录日志,暂时不需要处理，因为请求日志中就包含了登录日志
     * 但是可以给请求日志做一下分库分表
     */
    public void createLoginLog(JoinPoint joinPoint, HttpRequestContext httpRequestContext, boolean status) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        long rt = System.currentTimeMillis() - httpRequestContext.getStartTime();
        Integer userId = null;
        String userName = null;
        userId = BaseContextHandler.getUserID();
        userName = BaseContextHandler.getUserName();



    }
}
