package com.framework.security.integral.core.model.sys;

import java.util.Date;
import javax.persistence.*;

/**
 * @author gaoxu
 */
public class User {
    @Id
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    private Integer sex;

    private String email;

    private Long tel;

    /**
     * 是否删除（0为未删除 1为删除）
     */
    @Column(name = "is_delect")
    private Boolean isDelect;

    /**
     * 启用（0否 1是）
     */
    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return tel
     */
    public Long getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(Long tel) {
        this.tel = tel;
    }

    /**
     * 获取是否删除（0为未删除 1为删除）
     *
     * @return is_delect - 是否删除（0为未删除 1为删除）
     */
    public Boolean getIsDelect() {
        return isDelect;
    }

    /**
     * 设置是否删除（0为未删除 1为删除）
     *
     * @param isDelect 是否删除（0为未删除 1为删除）
     */
    public void setIsDelect(Boolean isDelect) {
        this.isDelect = isDelect;
    }

    /**
     * 获取启用（0否 1是）
     *
     * @return is_enable - 启用（0否 1是）
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 设置启用（0否 1是）
     *
     * @param isEnable 启用（0否 1是）
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }
}