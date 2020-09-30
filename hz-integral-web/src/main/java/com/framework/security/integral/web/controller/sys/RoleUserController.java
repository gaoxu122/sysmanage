package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.sys.RoleUserMapper;
import com.framework.security.integral.core.model.sys.RoleUser;
import com.framework.security.integral.web.biz.sys.RoleUserBiz;
import org.springframework.web.bind.annotation.*;

/**
 * 人员赋予角色
 *
 * @author gaoxu
 */
@RestController
@RequestMapping("/role_user")
public class RoleUserController extends BaseController<RoleUserBiz, RoleUserMapper> {

    @PostMapping("/insert_role_user")
    public ObjectRestResponse insertRoleUser(RoleUser roleUser) {

        return baseBiz.insertRoleForUser(roleUser);
    }

    @GetMapping("/select_permission")
    public ObjectRestResponse selectPermission(int roleId, String userName) {
        return baseBiz.selectPermission(roleId, userName);
    }

    @DeleteMapping("/delete_role_user")
    public ObjectRestResponse deleteRoleUser() {
        return ObjectRestResponse.success();
    }

}
