package com.framework.security.integral.common.constant;

/**
*PBReturnCode
 *
*返回错误码，对外接口一定要设置错误码 错误码按照顺序递增，不要重复
 *
*@author jianghx
*@create 2018/8/20 10:08
**/
public enum ResultCode {

    /**
     * 正常响应状态码
     */
    SUCCESS(0, "成功"),
    SYS_ERROR(-1, "系统繁忙"),

    REQUEST_METHOD_ERROR(405, "请求方式错误"),

    ERROR_REQUEST(400, "错误请求"),

    REQUEST_NOT_EXIST(404, "请求方式不存在"),

    REQUEST_PARAM_EXIST(406, "请求所需参数不存在"),

    TOKEN_FORBIDDEN_NULL_CODE(505,"token不存"),
    TOKEN_FORBIDDEN_EXPIRE_CODE(506,"token过期"),
    TOKEN_FORBIDDEN_SIGNATURE_CODE(507,"签名错误"),



    ;







    private Integer code;

    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg" + msg;
    }
}
