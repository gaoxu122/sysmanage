package com.framework.security.integral.core.model.sys;

import java.util.Date;
import javax.persistence.*;

public class Menu {
    /**
     * 菜单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单名
     */
    private String title;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 深度
     */
    private String path;

    /**
     * 索引
     */
    private String name;

    /**
     * 图标
     */
    private String ioc;

    /**
     * 地址(vue地址)
     */
    private String address;

    /**
     * 是否删除（0：否 1：是）
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 是否启用 （0：否 1：是）
     */
    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modfied")
    private Date gmtModfied;

    /**
     * 获取菜单id
     *
     * @return id - 菜单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单id
     *
     * @param id 菜单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名
     *
     * @return title - 菜单名
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单名
     *
     * @param title 菜单名
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取父id
     *
     * @return parent_id - 父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
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
     * 获取索引
     *
     * @return index - 索引
     */
    public String getName() {
        return name;
    }

    /**
     * 设置索引
     *
     * @param name 索引
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图标
     *
     * @return ioc - 图标
     */
    public String getIoc() {
        return ioc;
    }

    /**
     * 设置图标
     *
     * @param ioc 图标
     */
    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    /**
     * 获取地址(vue地址)
     *
     * @return address - 地址(vue地址)
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址(vue地址)
     *
     * @param address 地址(vue地址)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取是否删除（0：否 1：是）
     *
     * @return is_delete - 是否删除（0：否 1：是）
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除（0：否 1：是）
     *
     * @param isDelete 是否删除（0：否 1：是）
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取是否启用 （0：否 1：是）
     *
     * @return is_enable - 是否启用 （0：否 1：是）
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用 （0：否 1：是）
     *
     * @param isEnable 是否启用 （0：否 1：是）
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
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
     * @return gmt_modfied - 修改时间
     */
    public Date getGmtModfied() {
        return gmtModfied;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModfied 修改时间
     */
    public void setGmtModfied(Date gmtModfied) {
        this.gmtModfied = gmtModfied;
    }
}