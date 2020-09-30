package com.framework.security.integral.api.model.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jianghx
 * @create 2019/4/2 10:41
 **/
@Data
public class UserLoginBo implements Serializable {

    private static final long serialVersionUID = -1L;

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

    public UserLoginBo() {
    }

    public UserLoginBo(Integer userId, String userName, Integer deptId, String deptName, Integer roleId) {
        this.userId = userId;
        this.userName = userName;
        this.deptId = deptId;
        this.deptName = deptName;
        this.roleId = roleId;
    }
}
