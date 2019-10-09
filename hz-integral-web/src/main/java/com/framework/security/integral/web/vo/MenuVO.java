package com.framework.security.integral.web.vo;

import com.framework.security.integral.common.vo.TreeNode;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author gaoxu
 * @date 2019-07-11 16:32
 */
public class MenuVO extends TreeNode {
    /**
     * 菜单名
     */
    private String menuName;
    private String path;
    /**
     * 级联选择器的key
     */
    private String value;
    /**
     * 级联选择的值
     */
    private String label;


    /**
     * 图标
     */
    private String ioc;

    /**
     * 地址
     */
    private String address;
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
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modfied")
    private Date gmtModfied;

    public String getIoc() {
        return ioc;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDelect() {
        return isDelect;
    }

    public void setDelect(Boolean delect) {
        isDelect = delect;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModfied() {
        return gmtModfied;
    }

    public void setGmtModfied(Date gmtModfied) {
        this.gmtModfied = gmtModfied;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
