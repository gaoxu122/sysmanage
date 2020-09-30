package com.framework.security.integral.core.dao.sys;

import com.framework.security.integral.core.vo.RoleUserVO;
import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.core.vo.UserTokenDetail;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author gaoxu
 */
public interface UserMapper extends Mapper<User> {
    /**
     * 根据登录明和密码验证登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    User checkUser(@Param("userName") String userName, @Param("pwd") String pwd);

    /**
     * 批量删除
     *
     * @param list 传递的集合数组
     * @return
     */
    int batchDeleteUser(List<Integer> list);

    /**
     * 获得用户的相关信息，用于生成token
     *
     * @param userId
     */
    UserTokenDetail getUserRelateInfo(@Param("userId") Integer userId);

    /**
     *  根据用户名获取角色
     * @param userName
     * @return
     */
    RoleUserVO selectRoleByUserName(@Param("userName") String userName);

}