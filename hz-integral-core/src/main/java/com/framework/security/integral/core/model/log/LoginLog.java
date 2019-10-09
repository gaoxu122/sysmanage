package com.framework.security.integral.core.model.log;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login_log")
public class LoginLog {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 客户端ip
     */
    @Column(name = "client_ip")
    private String clientIp;

    /**
     * 类名
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 方法名
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 请求类型
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 企业名称
     */
    @Column(name = "corp_name")
    private String corpName;

    /**
     * 企业id
     */
    @Column(name = "corp_id")
    private Long corpId;

    /**
     * 用户id
     */
    @Column(name = "user_Id")
    private Long userId;

    /**
     * 状态（1：成功 0：失败）
     */
    private Boolean status;

    /**
     * 登录信息
     */
    @Column(name = "login_msg")
    private String loginMsg;

    /**
     * 失败原因
     */
    @Column(name = "fail_msg")
    private String failMsg;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取客户端ip
     *
     * @return client_ip - 客户端ip
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 设置客户端ip
     *
     * @param clientIp 客户端ip
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * 获取类名
     *
     * @return class_name - 类名
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置类名
     *
     * @param className 类名
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取方法名
     *
     * @return method_name - 方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置方法名
     *
     * @param methodName 方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modify - 修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModify 修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取请求类型
     *
     * @return request_method - 请求类型
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * 设置请求类型
     *
     * @param requestMethod 请求类型
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取企业名称
     *
     * @return corp_name - 企业名称
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * 设置企业名称
     *
     * @param corpName 企业名称
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    /**
     * 获取企业id
     *
     * @return corp_id - 企业id
     */
    public Long getCorpId() {
        return corpId;
    }

    /**
     * 设置企业id
     *
     * @param corpId 企业id
     */
    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    /**
     * 获取用户id
     *
     * @return user_Id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取状态（1：成功 0：失败）
     *
     * @return status - 状态（1：成功 0：失败）
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态（1：成功 0：失败）
     *
     * @param status 状态（1：成功 0：失败）
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取登录信息
     *
     * @return login_msg - 登录信息
     */
    public String getLoginMsg() {
        return loginMsg;
    }

    /**
     * 设置登录信息
     *
     * @param loginMsg 登录信息
     */
    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }

    /**
     * 获取失败原因
     *
     * @return fail_msg - 失败原因
     */
    public String getFailMsg() {
        return failMsg;
    }

    /**
     * 设置失败原因
     *
     * @param failMsg 失败原因
     */
    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }
}