package com.huizhiframework.security.permissions.model.user;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_user_auth_log")
public class UserAuthLogDO {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 授权id
     */
    @Column(name = "auth_id")
    private Long authId;

    /**
     * 登录ip
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * ip所在区域
     */
    @Column(name = "Ip_address")
    private String ipAddress;

    /**
     * 来源0:app,1pc
     */
    private Integer source;

    /**
     * 浏览器信息
     */
    @Column(name = "browser_Info")
    private String browserInfo;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 登录类型:0用户名密码,1钉钉扫码
     */
    @Column(name = "login_type")
    private Integer loginType;

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
     * 获取授权id
     *
     * @return auth_id - 授权id
     */
    public Long getAuthId() {
        return authId;
    }

    /**
     * 设置授权id
     *
     * @param authId 授权id
     */
    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    /**
     * 获取登录ip
     *
     * @return login_ip - 登录ip
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置登录ip
     *
     * @param loginIp 登录ip
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取登录时间
     *
     * @return login_date - 登录时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置登录时间
     *
     * @param loginDate 登录时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取ip所在区域
     *
     * @return Ip_address - ip所在区域
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置ip所在区域
     *
     * @param ipAddress ip所在区域
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * 获取来源0:app,1pc
     *
     * @return source - 来源0:app,1pc
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 设置来源0:app,1pc
     *
     * @param source 来源0:app,1pc
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 获取浏览器信息
     *
     * @return browser_Info - 浏览器信息
     */
    public String getBrowserInfo() {
        return browserInfo;
    }

    /**
     * 设置浏览器信息
     *
     * @param browserInfo 浏览器信息
     */
    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modified - 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
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
     * 获取登录类型:0用户名密码,1钉钉扫码
     *
     * @return login_type - 登录类型:0用户名密码,1钉钉扫码
     */
    public Integer getLoginType() {
        return loginType;
    }

    /**
     * 设置登录类型:0用户名密码,1钉钉扫码
     *
     * @param loginType 登录类型:0用户名密码,1钉钉扫码
     */
    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }
}