package com.framework.security.integral.api.model.user;

import lombok.Data;

/**
 * @author jianghx
 * @create 2019/4/2 10:41
 **/
@Data
public class UserLoginVo {


    /**
     * 系统用户id用户
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户账号
     */
    private String userName;


    /**
     * 系统企业id
     */

    private long corpId;

    private String agentId;

    /**
     * 钉钉企业id
     */
    private String dingId;
    /**
     * 所属角色id

     */
    private Long roleId;
    public UserLoginVo() {
    }

    public UserLoginVo(Long userId, String name, String userName, long corpId, String agentId, Long roleId,String dingId) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.corpId = corpId;
        this.agentId = agentId;
        this.roleId = roleId;
        this.dingId=dingId;
    }
}
