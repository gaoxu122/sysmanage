package com.framework.security.integral.core.model.log;

import java.util.Date;
import javax.persistence.*;

@Table(name = "exception_log")
public class ExceptionLog {
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
     * 发生异常时间
     */
    @Column(name = "exception_time")
    private Date exceptionTime;

    /**
     * 是否查看0:否，1是
     */
    @Column(name = "is_view")
    private Boolean isView;

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
     * 异常类型
     */
    @Column(name = "exception_type")
    private String exceptionType;

    /**
     * 异常信息
     */
    @Column(name = "exception_msg")
    private String exceptionMsg;

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
     * 获取发生异常时间
     *
     * @return exception_time - 发生异常时间
     */
    public Date getExceptionTime() {
        return exceptionTime;
    }

    /**
     * 设置发生异常时间
     *
     * @param exceptionTime 发生异常时间
     */
    public void setExceptionTime(Date exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    /**
     * 获取是否查看0:否，1是
     *
     * @return is_view - 是否查看0:否，1是
     */
    public Boolean getIsView() {
        return isView;
    }

    /**
     * 设置是否查看0:否，1是
     *
     * @param isView 是否查看0:否，1是
     */
    public void setIsView(Boolean isView) {
        this.isView = isView;
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
     * 获取异常类型
     *
     * @return exception_type - 异常类型
     */
    public String getExceptionType() {
        return exceptionType;
    }

    /**
     * 设置异常类型
     *
     * @param exceptionType 异常类型
     */
    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    /**
     * 获取异常信息
     *
     * @return exception_msg - 异常信息
     */
    public String getExceptionMsg() {
        return exceptionMsg;
    }

    /**
     * 设置异常信息
     *
     * @param exceptionMsg 异常信息
     */
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}