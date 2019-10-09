package com.framework.security.integral.core.model.sys;

import java.util.Date;
import javax.persistence.*;

public class Department {
    @Id
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

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
     * 创建者ip
     */
    @Column(name = "creator_ip")
    private String creatorIp;

    /**
     * 上级id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 深度
     */
    private String path;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 排序值
     */
    private Integer sort;

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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取创建者ip
     *
     * @return creator_ip - 创建者ip
     */
    public String getCreatorIp() {
        return creatorIp;
    }

    /**
     * 设置创建者ip
     *
     * @param creatorIp 创建者ip
     */
    public void setCreatorIp(String creatorIp) {
        this.creatorIp = creatorIp;
    }

    /**
     * 获取上级id
     *
     * @return parent_id - 上级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级id
     *
     * @param parentId 上级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取深度
     *
     * @return path - 深度
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置深度
     *
     * @param path 深度
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return is_delete
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return is_enable
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * @param isEnable
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取排序值
     *
     * @return sort - 排序值
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序值
     *
     * @param sort 排序值
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}