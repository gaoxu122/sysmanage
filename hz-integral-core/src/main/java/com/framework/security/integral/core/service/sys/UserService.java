package com.framework.security.integral.core.service.sys;

import com.framework.security.integral.core.dao.sys.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-03 17:39
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 检查用户名是否存在
     *
     * @return
     */
    public Integer checkUserName(String userName) {
        int flag = -1;
        try {

            List<String> list = userMapper.getUserNameByUser(userName);
            if (null == list) {
                flag = 0;
            }
            if (list.contains(userName)) {
                flag = 2;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }


    public Boolean batchDeleteUser(List<Integer> list) {
        boolean flag = false;
        try {

            userMapper.batchDeleteUser(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
