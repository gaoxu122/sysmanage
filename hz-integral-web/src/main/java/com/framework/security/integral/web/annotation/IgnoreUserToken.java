package com.framework.security.integral.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*IgnoreUserToken
 *
*忽略用户鉴权
 *
*@author jianghx
*@create 2018/8/24 10:42
**/
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface IgnoreUserToken {
}
