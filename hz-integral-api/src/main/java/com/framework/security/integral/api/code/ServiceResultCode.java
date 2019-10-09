package com.framework.security.integral.api.code;

/**
*PBReturnCode
 *
*返回错误码，对外接口一定要设置错误码 错误码按照顺序递增，不要重复
 *
*@author jianghx
*@create 2018/8/20 10:08
**/
public enum ServiceResultCode {


    //0-1000为框架异常错误

    PARAMS_IS_NULL(600,"参数为空"),
    FRAMEWORK_RESPONSE_RESULT_ERROR(999, "响应类型必须为BaseResponse子类"),


    //1000-2000为系统关键参数未设置性错误

    LOGIN_DING_USER_NOT_EXIST(1000,"用户不存在"),
    LOGIN_DING_USER_NO_RELATIONS(1001,"用户未关联部门或者企业"),
    LOGIN_DING_CORP_NOT_AUTH(1002,"企业未被授权"),
    LOGIN_DING_CORP_NOT_EXIST(1003,"企业信息不存在"),
    LOGIN_DING_CREATE_TOKEN_ERROR(1004,"token生成异常"),

    //2000-3000为钉钉接口调用异常,异常与钉钉接口相关
    DING_CORP_TOKEN(2001, "获取token异常"),
    DING_CORP_TIKET(2002, "获取ticket异常"),
    DING_SSO_TOKEN(2003,"获取ssoToken异常"),

    //2050-2070为调用钉钉用户接口异常
    DING_USER_USERID_FAILE(2050, "获取用户id失败"),
    DING_USER_USERINFO_FAILE(2051, "获取用户基础信息失败"),
    DING_USER_DEPT_USERID_FAILE(2052, "获取部门用户id失败"),
    DING_USER_DEPT_USER_FAILE(2053, "获取部门用户失败"),
    DING_USER_USERINFO_PC_FAILE(2054, "扫码信息获取失败"),
    DING_USER_USERINFO_SSO_FATLE(2055,"获取用户基础信息失败"),

    //2070-2090为调用钉钉用户接口异常
    DING_DEPT_LIST_FATIL(2070,"获取部门列表异常"),
    DING_DEPT_DETAIL_FATIL(2071,"获取部门详细信息异常"),
    DING_DEPT_ORG_USER_COUNT_FATIL(2072,"获取部门详细信息异常"),

    //2090-3000事件注册相关
    DING_EVENT_RIGISTE_FAILE(2090,"事件注册失败"),
    DING_EVENT_GET_FAILE(2091,"事件调用失败"),
    DING_EVENT_UPDATE_FAILE(2092,"事件更新调用失败"),

    DING_EVENT_GET_PARAM_IS_NULL(2093,"事件调用agentId不能为空"),
    //3000-5000为框架业务上错误
    BIZ_CORP_TOKEN(3001, "获取企业token异常"),
    BIZ_CORP_NOTE_SET(3002, "企业信息未初始化"),
    BIZ_CORP_INFO_ERROR(3003,"企业信息获取失败"),
    BIZ_CORP_TIKET(3004, "获取企业token异常"),
    BIZ_SSO_TOKEN(3005,"获取企业的SSOToken异常"),
    //3050-3060为框架业务上错误
    LOGIN_PARAMS_IS_NULL(3050, "参数获取错误"),
    LOGIN_USER_IS_NOT_ACTIVE(3051, "用户没有激活"),
    ;







    private int code;

    private String msg;

    ServiceResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
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
