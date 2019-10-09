package com.framework.security.integral.web.util.jwt;

import com.framework.security.integral.common.constant.CommonConstants;
import com.framework.security.integral.common.util.StringHelper;
import com.framework.security.integral.api.model.user.UserLoginVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
*JwtHelper
 *
*@description
 *
*@author jianghx
*@create 2018/8/29 10:13
**/
public class JwtHelper {
    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    /**
     *
     * @param uservo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(UserLoginVo uservo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(uservo.getName())
                .claim(CommonConstants.CONTEXT_KEY_USER_ID, uservo.getUserId())
                .claim(CommonConstants.CONTEXT_KEY_CORP_ID, uservo.getCorpId())
                .claim(CommonConstants.CONTEXT_KEY_ROLE_ID, uservo.getRoleId())
                .claim(CommonConstants.CONTEXT_KEY_USER_NAME, uservo.getUserName())
                .claim(CommonConstants.CONTEXT_KEY_AGENT_ID, uservo.getAgentId())
                .claim(CommonConstants.CONTEXT_KEY_DING_ID, uservo.getDingId())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * token加密
     * @param uservo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(UserLoginVo uservo, byte[] priKey, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(uservo.getName())
                .claim(CommonConstants.CONTEXT_KEY_USER_ID, uservo.getUserId())
                .claim(CommonConstants.CONTEXT_KEY_CORP_ID, uservo.getCorpId())
                .claim(CommonConstants.CONTEXT_KEY_ROLE_ID, uservo.getRoleId())
                .claim(CommonConstants.CONTEXT_KEY_USER_NAME, uservo.getUserName())
                .claim(CommonConstants.CONTEXT_KEY_AGENT_ID, uservo.getAgentId())
                .claim(CommonConstants.CONTEXT_KEY_DING_ID, uservo.getDingId())
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
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
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
    public static UserLoginVo getInfoFromToken(String token, byte[] pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();


        return new UserLoginVo(Long.valueOf(StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USER_ID))),body.getSubject(),
                StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USER_NAME)),Long.valueOf(StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_CORP_ID))),
                StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_AGENT_ID)),Long.valueOf(StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_ROLE_ID))),
                StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_DING_ID))
                );
    }

}
