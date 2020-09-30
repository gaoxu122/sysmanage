package com.framework.security.integral.core.vo;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author gaoxu
 */
@Data
public class RoleMenuVO {


    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "name")
    private String menuName;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;


}
