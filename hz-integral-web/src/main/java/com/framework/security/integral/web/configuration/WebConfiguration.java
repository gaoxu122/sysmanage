package com.framework.security.integral.web.configuration;

import com.framework.security.integral.web.intercepter.UserAuthRestInterceptor;
import com.framework.security.integral.common.handler.GlobalExceptionHandler;
import com.framework.security.integral.common.log.http.HttpRequestInteceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

/**
*WebConfiguration
 *
*@description
 *
*@author jianghx
*@create 2018/8/22 14:12
**/
@Configuration()
@Primary
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getHttpRequestInteceptor());
        registry.addInterceptor(getUserAuthRestInterceptor());


    }


    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

    @Bean
    HttpRequestInteceptor getHttpRequestInteceptor() {
        return new HttpRequestInteceptor();
    }

    /**
     * 需要用户和服务认证判断的路径
     * @return
     */
    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/user/**",
                "/dict/**",
        };
        Collections.addAll(list, urls);
        return list;
    }

}
