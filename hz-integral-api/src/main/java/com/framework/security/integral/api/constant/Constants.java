package com.framework.security.integral.api.constant;

/**
 * @author jianghx
 * @create 2019/4/2 10:48
 **/
public class Constants {


    /**
     * 钉钉token有效时长
     */
    public static final Integer CORP_TOKEN_EXPIRED_TIME = 7200;
    /**
     * 钉钉TICKET有效时长
     */
    public static final Integer CORP_TICKET_EXPIRED_TIME = 7200;
    /**
     * 系统成功标识
     */
    public static final String SYS_SUCCESS = "success";

    /**
     * 系统失败
     */
    public static final String SYS_FAiLE = "fail";

    /**
     * 提前10分钟校验钉钉企业token
     */
    public static final Integer CORP_TOKEN_ADD_TIME = 600;
    /**
     * 提前10分钟校验钉钉企业TICKET
     */
    public static final Integer CORP_TICKET_ADD_TIME = 600;
    /**
     * 系统token有效时长
     */
    public static final Integer SYS_TOKEN_EXPIRED_TIME = 7200;

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，
     * 从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成，
     * ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
     */
    public static final String ENCODING_AES_KEY = "1234567890123456789012345678901234567890123";
    /**
     *  加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
     */
    public static final String ENCODING_TOKEN = "123456";


}
