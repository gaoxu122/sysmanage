package com.framework.security.integral.core.model.sys;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
public class Menu {
    /**
     * 菜单id
     */
    @Id
    private Integer id;

    /**
     * 菜单名
     */
    private String name;

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
    @Column(name = "is_delete")
    private Boolean isDelete;

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

}