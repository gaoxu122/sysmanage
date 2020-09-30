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
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author gaoxu
 * @date 2019-07-03 16:28
 *  添加功能
 *  1.登陆时间
 *  2.访问量
 */

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class LoginBiz {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtService jwtService;



    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public ObjectRestResponse login(UserLoginVO user) {

        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }
        //判断用户名是否存在
        Boolean aBoolean = userService.checkUserName(user.getUserName(), user.getPassword());
        log.debug("用户验证信息： {}", aBoolean.toString());
        if (!aBoolean) {
            return ObjectRestResponse.failure(ReturnCode.PASSWORD_CANNOT_BE_EMPTY.getCode(), ReturnCode.PASSWORD_CANNOT_BE_EMPTY.getMsg());
        }

        // 用户登录的时候也生成token
        String token = jwtService.generateToken(user);

        return ObjectRestResponse.success(token);
    }

    /**
     * 注册    消息队列
     * 用户注册完成后，给用户发送邮件
     *
     * <>后期添加短信通知</>
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
//            User insertUser = MiteBeanUtils.doToDto(user, User.class);
            User insertUser = UserEntity.setUser(user);
            userMapper.insertSelective(insertUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.success();
    }

}
