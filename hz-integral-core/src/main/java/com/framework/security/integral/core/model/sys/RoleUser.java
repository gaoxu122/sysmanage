package com.framework.security.integral.core.model.sys;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author gaoxu
 */
@Table(name = "role_user")
@Data
public class RoleUser {
    @Id
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 是否删除（0: 否1:是）
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;
}