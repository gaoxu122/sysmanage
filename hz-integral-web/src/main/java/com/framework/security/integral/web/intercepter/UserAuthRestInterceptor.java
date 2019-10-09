package com.framework.security.integral.web.intercepter;

import com.framework.security.integral.web.annotation.IgnoreUserToken;
import com.framework.security.integral.api.model.user.UserLoginVo;
import com.framework.security.integral.common.context.BaseContextHandler;
import com.framework.security.integral.web.configuration.UserAuthConfig;
import com.framework.security.integral.web.configuration.UserAuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*UserAuthRestInterceptor
 *
*根据token初始化用户信息
 *
*@author jianghx
*@create 2018/8/21 14:41
**/
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private UserAuthUtil userAuthUtil;

    private Logger logger = LoggerFactory.getLogger(UserAuthRestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 配置该注解，说明不进行用户拦截
        IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
        }
        if (annotation != null||request.getRequestURI().startsWith("/api")) {
                return super.preHandle(request, response, handler);
        }

        String token = request.getHeader(userAuthConfig.getTokenHeader());
        UserLoginVo infoFromToken = userAuthUtil.getInfoFromToken(token);

        String name = infoFromToken.getName();
        BaseContextHandler.setUserId(infoFromToken.getUserId());
        BaseContextHandler.setName(name);
        BaseContextHandler.setCorpId(infoFromToken.getCorpId());
        BaseContextHandler.setAgentId(infoFromToken.getAgentId());
        BaseContextHandler.setDingId(infoFromToken.getDingId());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();

        System.out.println("");
        super.afterCompletion(request, response, handler, ex);
    }
}
