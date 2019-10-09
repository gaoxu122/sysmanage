package com.framework.security.integral.api.exception;

import com.framework.security.integral.common.exception.BaseException;

public class UserInvalidException extends BaseException {
    public UserInvalidException(String message, int code) {
        super(message, code);
    }
}
