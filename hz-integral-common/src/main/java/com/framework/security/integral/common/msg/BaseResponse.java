package com.framework.security.integral.common.msg;

import com.framework.security.integral.common.constant.ResultCode;

/**
 * BaseResponse
 * <p>
 * 公共响应类
 *
 * @author jianghx
 * @create 2018/8/21 15:31
 **/
public class BaseResponse {
    private int status;
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
        this.status = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMsg();

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
