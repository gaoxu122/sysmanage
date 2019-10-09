package com.huizhiframework.security.permissions.model.user;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_user")
public class UserDO {
    /**
     * 用户id
     */
    @Id
    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 激活状态
     */
    private Boolean active;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 登录账号
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取激活状态
     *
     * @return active - 激活状态
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 设置激活状态
     *
     * @param active 激活状态
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
     * 获取登录账号
     *
     * @return user_name - 登录账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置登录账号
     *
     * @param userName 登录账号
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}