package com.framework.security.integral.web.util.jwt;

import com.framework.security.integral.common.constant.CommonConstants;
import com.framework.security.integral.common.constant.ResultCode;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.util.StringHelper;
import com.framework.security.integral.api.model.user.UserLoginBo;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

/**
 * JwtHelper
 *
 * @author gaoxu
 * @description
 * @create 2018/8/29 10:13
 **/

@Slf4j
public class JwtHelper {
    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     * 生成token
     *
     * @param userLoginBo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(UserLoginBo userLoginBo, String priKeyPath, int expire) throws Exception {

        log.info("生成对象:{},  签名:{},  {}", userLoginBo.toString(), priKeyPath, expire);
        String compactJws = null;
        try {
            compactJws = Jwts.builder()
                    .setSubject(userLoginBo.getUserName())
                    .claim(CommonConstants.CONTEXT_KEY_USER_ID, userLoginBo.getUserId())
                    .claim(CommonConstants.CONTEXT_KEY_USER_DEPT_ID, userLoginBo.getDeptId())
                    .claim(CommonConstants.CONTEXT_KEY_USER_DEPT_NAME, userLoginBo.getDeptName())
                    .claim(CommonConstants.CONTEXT_KEY_USER_ROLE_TYPE, userLoginBo.getRoleId())
                    .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                    .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
                    .compact();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return compactJws;
    }

    /**
     * token加密
     *
     * @param uservo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(UserLoginBo uservo, byte[] priKey, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(uservo.getUserName())
                .claim(CommonConstants.CONTEXT_KEY_USER_ID, uservo.getUserId())
                .claim(CommonConstants.CONTEXT_KEY_USER_NAME, uservo.getUserName())
                .claim(CommonConstants.CONTEXT_KEY_USER_DEPT_ID, uservo.getDeptId())
                .claim(CommonConstants.CONTEXT_KEY_USER_DEPT_NAME, uservo.getDeptName())
                .claim(CommonConstants.CONTEXT_KEY_USER_ROLE_TYPE, uservo.getRoleId())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {

        Jws<Claims> claimsJws = null;
        try {
            claimsJws= Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
//            claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static UserLoginBo getInfoFromToken(String token, byte[] pubKeyPath) throws Exception {

        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        if (claimsJws == null) {
            throw new BaseException(ResultCode.TOKEN_FORBIDDEN_EXPIRE_CODE.getMsg(), ResultCode.TOKEN_FORBIDDEN_EXPIRE_CODE.getCode());
        }
        Claims body = claimsJws.getBody();


        return new UserLoginBo(Integer.valueOf(StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USER_ID))),
                body.getSubject(),
                Integer.valueOf(StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USER_DEPT_ID))),
                StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USER_DEPT_NAME)),
                Integer.valueOf(StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USER_ROLE_TYPE))));

    }

}
