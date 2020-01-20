package com.framework.security.integral.web.biz;

import com.framework.security.integral.api.model.user.UserLoginBo;
import com.framework.security.integral.core.dao.sys.UserMapper;
import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.core.vo.UserTokenDetail;
import com.framework.security.integral.web.configuration.KeyConfiguration;
import com.framework.security.integral.web.util.MiteBeanUtils;
import com.framework.security.integral.web.vo.UserLoginVO;
import com.framework.security.integral.common.constant.ResultCode;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.web.configuration.UserAuthConfig;
import com.framework.security.integral.web.util.jwt.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gaoxu
 */
@Service
@Slf4j
public class JwtService {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Autowired
    private UserMapper userMapper;

    public String generateToken(UserLoginVO user) {

        String token;

        User dbUser = userMapper.selectOne(MiteBeanUtils.dtoToE(user, User.class));
        UserTokenDetail userRelateInfo = userMapper.getUserRelateInfo(dbUser.getId());
        UserLoginBo userLoginBo = new UserLoginBo();
        userLoginBo.setUserId(userRelateInfo.getUserId());
        userLoginBo.setUserName(userRelateInfo.getUserName());
        userLoginBo.setDeptId(userRelateInfo.getDeptId());
        userLoginBo.setDeptName(userRelateInfo.getDeptName());
        userLoginBo.setRoleId(userRelateInfo.getRoleId());

        try {
            token = JwtHelper.generateToken(userLoginBo, keyConfiguration.getUserPriKey(), userAuthConfig.getExpire());
        } catch (Exception e) {
            throw new BaseException(ResultCode.SET_TOKEN_FILL.getMsg(), ResultCode.SET_TOKEN_FILL.getCode());
        }

        return token;
    }

}
