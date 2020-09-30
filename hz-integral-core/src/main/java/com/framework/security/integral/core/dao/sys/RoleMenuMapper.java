package com.framework.security.integral.core.dao.sys;

import com.framework.security.integral.core.model.sys.RoleMenu;
import com.framework.security.integral.core.vo.RoleMenuVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {


    List<RoleMenuVO> getMenusByRole(@Param(value = "roleId") Integer roleId);

    Integer batchInsertRoleMenu(@Param("roleMenus") List<RoleMenu> roleMenus);
}