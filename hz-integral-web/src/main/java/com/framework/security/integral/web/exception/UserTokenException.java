package com.framework.security.integral.web.exception;


import com.framework.security.integral.common.exception.BaseException;

/**
*UserTokenException
 *
*token 异常类
 *
*@author jianghx
*@create 2018/8/23 16:06
**/
public class UserTokenException extends BaseException {

    public UserTokenException(String message, int status) {
        super(message, status);
    }
}
