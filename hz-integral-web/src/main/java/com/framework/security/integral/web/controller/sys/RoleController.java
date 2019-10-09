package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.web.biz.sys.RoleBiz;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaoxu
 * @date 2019-10-08 12:49
 */


@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<RoleBiz, RoleMapper> {

    /**
     * 获得所有的角色
     *
     * @return
     */
    @GetMapping("/select_role")
    public ObjectRestResponse getRole() {

        return baseBiz.getRoles();
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping("/insert_role")
    public ObjectRestResponse insertRole(Role role) {

        return baseBiz.insertRole(role);
    }

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    @PutMapping("/update_role")
    public ObjectRestResponse updateRole(Role role) {

        return baseBiz.updateRole(role);
    }

}
