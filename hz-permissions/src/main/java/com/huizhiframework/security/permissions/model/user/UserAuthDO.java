package com.huizhiframework.security.permissions.model.user;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_user_auth")
public class UserAuthDO {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 授权用户id
     */
    private Long userid;

    /**
     * 标识类型
     */
    @Column(name = "identity_type")
    private Integer identityType;

    /**
     * 标识，第三方登录标识，当用户名密码登录时候可以作为密码
     */
    private String identity;

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
     * 获取授权用户id
     *
     * @return userid - 授权用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置授权用户id
     *
     * @param userid 授权用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取标识类型
     *
     * @return identity_type - 标识类型
     */
    public Integer getIdentityType() {
        return identityType;
    }

    /**
     * 设置标识类型
     *
     * @param identityType 标识类型
     */
    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    /**
     * 获取标识，第三方登录标识，当用户名密码登录时候可以作为密码
     *
     * @return identity - 标识，第三方登录标识，当用户名密码登录时候可以作为密码
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 设置标识，第三方登录标识，当用户名密码登录时候可以作为密码
     *
     * @param identity 标识，第三方登录标识，当用户名密码登录时候可以作为密码
     */
    public void setIdentity(String identity) {
        this.identity = identity;
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
}