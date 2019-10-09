package com.framework.security.integral.common.log.http;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
*HttpRequestContextHolder
 *
*@description
 *
*@author jianghx
*@create 2019/4/4 11:26
**/

@Component
public class HttpRequestContextHolder {

    private ThreadLocal<HttpRequestContext> httpRequestContextThreadLocal = new ThreadLocal<HttpRequestContext>();

    public HttpRequestContext getHttpRequestContext() {
        return httpRequestContextThreadLocal.get();
    }

    public void setHttpRequestContext(HttpRequestContext httpRequestContext) {
        this.httpRequestContextThreadLocal.set(httpRequestContext);
    }

    public void clean() {
        httpRequestContextThreadLocal.remove();
    }

}
