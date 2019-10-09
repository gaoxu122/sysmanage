package com.framework.security.integral.web.biz;

import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.sys.UserMapper;
import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.core.service.sys.UserService;
import com.framework.security.integral.web.constant.ReturnCode;
import com.framework.security.integral.web.my.UserEntity;
import com.framework.security.integral.web.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author gaoxu
 * @date 2019-07-03 16:28
 */

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class LoginBiz {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    /**w
     * 用户登录
     *
     * @param user
     * @return
     */
    public ObjectRestResponse login(UserLoginVO user) {

        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }
        //  根据用户名检查用户是否已经存在
        Integer status = userService.checkUserName(user.getUserName());

        if (1 == status) {
            return ObjectRestResponse.failure(ReturnCode.USER_ALREADY_EXISTS.getCode(), ReturnCode.USER_ALREADY_EXISTS.getMsg());
        }

        // 用户第一次需要给用户提示先注册
        if (0 == status) {
            return ObjectRestResponse.failure(ReturnCode.NAME_CANNOT_BE_EMPTY.getCode(), ReturnCode.NAME_CANNOT_BE_EMPTY.getMsg());
        }

        return ObjectRestResponse.success();
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public ObjectRestResponse registered(UserLoginVO user) {

        if (StringUtils.isEmpty(user.getUserName())) {
            return ObjectRestResponse.failure(ReturnCode.NAME_CANNOT_BE_EMPTY.getCode(), ReturnCode.NAME_CANNOT_BE_EMPTY.getMsg());
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            return ObjectRestResponse.failure(ReturnCode.PASSWORD_CANNOT_BE_EMPTY.getCode(), ReturnCode.PASSWORD_CANNOT_BE_EMPTY.getMsg());
        }

        try {
            // 对用户赋值 并插入数据库
            User insertUser = UserEntity.setUser(user);
            userMapper.insertSelective(insertUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.success();
    }

}
