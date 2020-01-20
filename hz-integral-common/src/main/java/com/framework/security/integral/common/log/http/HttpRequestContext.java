package com.framework.security.integral.common.log.http;

import lombok.Data;

/**
 *
 * @author mint
 * @date 16-1-27
 */
@Data
public class HttpRequestContext {

    private Long startTime;
    private String clientIp;
    private String requestMethod;
    private String requestURI;
    private String requestURL;
    private String query;
    private String cookies;

    private String method;


    @Override
    public String toString() {
        return "HttpRequestContext{" +
                "startTime=" + startTime +
                ", clientIp='" + clientIp + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestURI='" + requestURI + '\'' +
                ", requestURL='" + requestURL + '\'' +
                ", query='" + query + '\'' +
                ", cookies='" + cookies + '\'' +
                '}';
    }
}
