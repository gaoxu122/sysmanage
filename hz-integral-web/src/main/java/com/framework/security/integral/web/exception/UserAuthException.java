package com.framework.security.integral.web.exception;

import com.framework.security.integral.common.exception.BaseException;
/**
*UserAuthException
 *
*@description
 *
*@author jianghx
*@create 2019/4/22 16:54
**/
public class UserAuthException extends BaseException {
    public UserAuthException(String message, int code) {
        super(message, code);
    }
}
