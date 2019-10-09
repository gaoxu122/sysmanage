package com.framework.security.integral.web.configuration;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
*UserAuthConfig
 *
*用户配置类
 *
*@author jianghx
*@create 2018/8/14 21:45
**/
@Configuration
@Data
public class UserAuthConfig {

    @Value("${auth.user.token-header}")
    private String tokenHeader;
    @Value("${auth.user.expire}")
    private Integer expire;
    @Value("${auth.user.rsa-secret}")
    private String rsaSecret;

    private byte[] pubKeyByte;


    public String getToken(HttpServletRequest request){
        return request.getHeader(this.getTokenHeader());
    }
}
