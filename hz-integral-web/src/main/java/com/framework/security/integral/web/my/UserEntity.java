package com.framework.security.integral.web.my;

import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.web.vo.UserLoginVO;

import java.util.Date;

/**
 * @author gaoxu
 * @date 2019-07-03 18:01
 */
public class UserEntity {

    /**
     * 对用户赋值
     *
     * @param user
     * @return
     */
    public static User setUser(UserLoginVO user) {


        User resultUser = new User();
        resultUser.setUserName(user.getUserName());
        resultUser.setGmtCreate(new Date());
        resultUser.setEmail(user.getEmail());
        resultUser.setPassword(user.getPassword());
        resultUser.setGmtModified(new Date());
        resultUser.setSex(user.getSex());
        resultUser.setTel(user.getTel());

        return resultUser;
    }


}
