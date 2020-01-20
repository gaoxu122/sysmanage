package com.framework.security.integral.core.service.sys;

import com.framework.security.integral.core.dao.sys.UserMapper;
import com.framework.security.integral.core.model.sys.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaoxu
 * @date 2019-07-03 17:39
 */

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 检查用户名是否存在
     *
     * @return
     */
    public Boolean checkUserName(String userName, String pwd) {
        log.info(this.getClass().getName() + "参数：userName:[" + userName + "] pwd: [" + pwd + "]");
        boolean flag = false;

        User user = userMapper.checkUser(userName, pwd);
        if (null != user) {
            flag = true;
        }
        return flag;
    }

    /**
     * 批量删除用户
     *
     * @param list
     * @return
     */
    public Boolean batchDeleteUser(List<Integer> list) {
        boolean flag = false;
        try {
            userMapper.batchDeleteUser(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据用户id的集合查询用户信息
     *
     * @param ids
     * @return
     */
    public List<User> selectUserByIds(String ids) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        List<String> idList = Arrays.asList(ids.split(",")).stream().map(s -> String.format(s.trim()))
                .collect(Collectors.toList());

        criteria.andIn("id", idList);

        return this.userMapper.selectByExample(example);
    }

}
