package com.framework.security.integral.core.dao.sys;

import com.framework.security.integral.core.model.sys.RoleUser;
import com.framework.security.integral.core.vo.RoleUserVO;
import com.framework.security.integral.core.vo.UserRoleVO;
import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface RoleUserMapper extends Mapper<RoleUser> {
    /**
     * 根据用户名获取角色
     *
     * @param userName
     * @return
     */
    RoleUserVO selectRoleByUserName(@Param("userName") String userName);

    List<UserRoleVO> selectNoPermissionUsersByRoleId(@Param("roleId") @NotNull int roleId,
                                                     @Param("userName") String userName);

    List<String> selectPermissionUsersByRoleId(@Param("roleId") @NotNull int roleId,
                                                @Param("userName") String userName);
}