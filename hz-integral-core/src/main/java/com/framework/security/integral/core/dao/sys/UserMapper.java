package com.framework.security.integral.core.dao.sys;

import com.framework.security.integral.core.model.sys.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    /**
     * 获得用户名集合
     *
     * @param userName
     * @return
     */
    public List<String> getUserNameByUser(String userName);

    /**
     * 批量删除
     *
     * @param list 传递的集合数组
     * @return
     */
    public int batchDeleteUser(List<Integer> list);

}