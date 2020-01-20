package com.framework.security.integral.core.vo;

import lombok.Data;

/**
 * @author gaoxu
 */
@Data
public class UserTokenDetail {

    /**
     * 系统用户id用户
     */
    private Integer userId;

    /**
     * 用户账号
     */
    private String userName;

    private Integer deptId;

    private String deptName;

    /**
     * 所属角色id
     */
    private Integer roleId;

}
