package com.framework.security.integral.core.model.log;

import java.util.Date;
import javax.persistence.*;

@Table(name = "request_log")
public class RequestLog {
    /**
     * 自增id
     */
    @Id
    private Long id;

    /**
     * 客户端ip
     */
    @Column(name = "client_ip")
    private String clientIp;

    /**
     * 请求类
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 请求方法
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * uri
     */
    @Column(name = "request_uri")
    private String requestUri;

    /**
     * 请求url
     */
    @Column(name = "request_url")
    private String requestUrl;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * cookie
     */
    private String cookies;

    /**
     * 耗费市场
     */
    private Long rt;

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
     * 1成功，0失败
     */
    private Boolean status;

    /**
     * 请求类型
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 参数
     */
    private String query;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
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
     * 获取请求类
     *
     * @return class_name - 请求类
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置请求类
     *
     * @param className 请求类
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取请求方法
     *
     * @return method_name - 请求方法
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置请求方法
     *
     * @param methodName 请求方法
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取uri
     *
     * @return request_uri - uri
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * 设置uri
     *
     * @param requestUri uri
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * 获取请求url
     *
     * @return request_url - 请求url
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 设置请求url
     *
     * @param requestUrl 请求url
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取cookie
     *
     * @return cookies - cookie
     */
    public String getCookies() {
        return cookies;
    }

    /**
     * 设置cookie
     *
     * @param cookies cookie
     */
    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    /**
     * 获取耗费市场
     *
     * @return rt - 耗费市场
     */
    public Long getRt() {
        return rt;
    }

    /**
     * 设置耗费市场
     *
     * @param rt 耗费市场
     */
    public void setRt(Long rt) {
        this.rt = rt;
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
     * 获取1成功，0失败
     *
     * @return status - 1成功，0失败
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置1成功，0失败
     *
     * @param status 1成功，0失败
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
     * 获取参数
     *
     * @return query - 参数
     */
    public String getQuery() {
        return query;
    }

    /**
     * 设置参数
     *
     * @param query 参数
     */
    public void setQuery(String query) {
        this.query = query;
    }
}