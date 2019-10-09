package com.framework.security.integral.common.exception;

/**
 *请求响应必须继承 BaseResponse
 *
 *@param
 *@return
 */
public class ResponseResultException extends BaseException {
    public ResponseResultException(String message, int code) {
        super(message, code);
    }
}
