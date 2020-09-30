package com.framework.security.integral.core.dao.sys;

import com.framework.security.integral.core.model.sys.Menu;
import com.framework.security.integral.core.vo.RoleMenuVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author gaoxu
 */
public interface MenuMapper extends Mapper<Menu> {

    List<RoleMenuVO> getMenusByRole(@Param(value = "roleId") Integer roleId);


}