package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.dao.sys.RoleMapper;
import com.framework.security.integral.core.model.sys.Role;
import com.framework.security.integral.web.biz.sys.RoleBiz;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

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
    public ObjectRestResponse getRole(@RequestParam Map<String, Object> map) {

        Query query = new Query(map);
        return baseBiz.getRoles(query);
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping("/insert_role")
    public ObjectRestResponse insertRole(@RequestBody Role role) {
        return baseBiz.insertRole(role);
    }

    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    @PutMapping("/update_role")
    public ObjectRestResponse updateRole(@RequestBody Role role) {
        return baseBiz.updateRole(role);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @DeleteMapping("/delete_role")
    public ObjectRestResponse deleteRole(int roleId) {
        return baseBiz.deleteRole(roleId);
    }

    @PutMapping("/enable")
    public ObjectRestResponse enable(Integer id) {
        return baseBiz.enable(id);
    }

}
