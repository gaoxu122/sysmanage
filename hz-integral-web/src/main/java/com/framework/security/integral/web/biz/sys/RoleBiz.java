package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.web.constant.ReturnCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-10-08 12:54
 */


@Service
public class RoleBiz extends BaseBiz<RoleMapper, Role> {


    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获得所有的角色列表
     *
     * @return
     */
    public ObjectRestResponse getRoles() {
        List<Role> roles = roleMapper.selectAll();
        return ObjectRestResponse.genJsonResultByOk(roles);
    }

    /**
     * 添加角色
     *
     * @return
     */
    public ObjectRestResponse insertRole(Role role) {

        // 判断不为空的项
        if (StringUtils.isBlank(role.getName())) {
            return ObjectRestResponse.failure(ReturnCode.ROLE_NAME_NOT_EMPTY.getCode(), ReturnCode.ROLE_NAME_NOT_EMPTY.getMsg());
        }
        role.setGmtCreate(new Date());
        role.setGmtModified(new Date());
        role.setIsEnable(false);
        role.setIsDelete(false);
        try {

            this.insert(role);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return ObjectRestResponse.genJsonResultByOk();
    }

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    public ObjectRestResponse updateRole(Role role) {

        // 判断不为空的项
        if (StringUtils.isBlank(role.getName())) {
            return ObjectRestResponse.failure(ReturnCode.ROLE_NAME_NOT_EMPTY.getCode(), ReturnCode.ROLE_NAME_NOT_EMPTY.getMsg());
        }

        this.updateSelectiveById(role);

        return ObjectRestResponse.success();
    }


}
