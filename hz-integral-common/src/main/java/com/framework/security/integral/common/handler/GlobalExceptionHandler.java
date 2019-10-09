package com.framework.security.integral.common.handler;

import com.framework.security.integral.common.constant.ResultCode;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.msg.BaseResponse;
import com.framework.security.integral.common.constant.ResultCode;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.msg.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

/**
*GlobalExceptionHandler
 *
*全局异常捕获异常捕获
 *
*@author jianghx
*@create 2018/8/20 10:14
**/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 通过异常捕获
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {

        logger.error(ex.getMessage(),ex);

        //405
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return new BaseResponse(ResultCode.REQUEST_METHOD_ERROR.getCode(), ResultCode.REQUEST_METHOD_ERROR.getMsg());

        }

        //400
        if (ex instanceof MissingServletRequestParameterException) {
            return new BaseResponse(ResultCode.ERROR_REQUEST.getCode(), ResultCode.ERROR_REQUEST.getMsg());

        }
        //404
        if (ex instanceof NoHandlerFoundException) {
            return new BaseResponse(ResultCode.REQUEST_NOT_EXIST.getCode(), ResultCode.REQUEST_NOT_EXIST.getMsg());
        }
        //入参不填
        if (ex instanceof MissingPathVariableException) {
            //
            return new BaseResponse(ResultCode.REQUEST_PARAM_EXIST.getCode(), ResultCode.REQUEST_PARAM_EXIST.getMsg());
        }


        return new BaseResponse(ResultCode.SYS_ERROR.getCode(), ResultCode.SYS_ERROR.getMsg());


    }


    /**
     * 系统异常
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(),ex);
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

}
