package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.sys.RoleMenuMapper;
import com.framework.security.integral.core.model.sys.RoleMenu;
import com.framework.security.integral.web.biz.sys.RoleMenuBiz;
import org.springframework.web.bind.annotation.*;


/**
 * @author gaoxu
 */
@RestController
@RequestMapping("/role_menu")
public class RoleMenuController extends BaseController<RoleMenuBiz, RoleMenuMapper> {


    @GetMapping(value = "/select_menu_by_role")
    public ObjectRestResponse selectMenusByRole(String userName) {
        return ObjectRestResponse.success(baseBiz.selectMenusByRoleId(userName));
    }

    @GetMapping(value = "/select_no_permission")
    public ObjectRestResponse selectNoPermissionMenu() {
        return baseBiz.selectNoPermissionMenu();
    }

    @GetMapping(value = "/select_permission")
    public ObjectRestResponse selectPermissionMenu(@RequestParam Integer id) {
        return baseBiz.selectPermissionMenu(id);
    }

    @PostMapping(value = "/insert_permission")
    public ObjectRestResponse insertPermissionMenu(Integer id, String menus) {
        return baseBiz.insertPermission(id, menus);
    }
}
