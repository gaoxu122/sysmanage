package com.framework.security.integral.web.configuration;

import com.framework.security.integral.web.exception.UserTokenException;
import com.framework.security.integral.api.model.user.UserLoginVo;
import com.framework.security.integral.common.constant.ResultCode;
import com.framework.security.integral.web.util.jwt.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
*UserAuthUtil
 *
*根据token获取用户基本信息
 *
*@author jianghx
*@create 2018/8/20 10:59
**/
@Configuration
public class UserAuthUtil {
    @Autowired
    private KeyConfiguration keyConfiguration;
    public UserLoginVo getInfoFromToken(String token) throws Exception {
        try {
            return JwtHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
        }catch (ExpiredJwtException ex){
            throw new UserTokenException(ResultCode.TOKEN_FORBIDDEN_EXPIRE_CODE.getMsg(),
                    ResultCode.TOKEN_FORBIDDEN_EXPIRE_CODE.getCode());
        }catch (SignatureException ex){
            throw new UserTokenException(ResultCode.TOKEN_FORBIDDEN_SIGNATURE_CODE.getMsg(),
                    ResultCode.TOKEN_FORBIDDEN_SIGNATURE_CODE.getCode());
        }catch (IllegalArgumentException ex){
            throw new UserTokenException(ResultCode.TOKEN_FORBIDDEN_NULL_CODE.getMsg(),
                    ResultCode.TOKEN_FORBIDDEN_NULL_CODE.getCode());
        }
    }
}
