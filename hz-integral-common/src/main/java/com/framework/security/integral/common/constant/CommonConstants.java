package com.framework.security.integral.common.constant;

/**
 * CommonConstants
 * <p>
 * 公共常量
 *
 * @author jianghx
 * @create 2018/8/21 11:57
 **/
public class CommonConstants {

    public static int PW_ENCORDER_SALT = 12;
    public static final Integer PAGE = 1;
    public static final Integer PAGE_SIZE = 20;
    public static final String RQUEST_LIMIT = "limit";
    public static final String RQUEST_PAGE = "page";
    public static final String STRING_SPLITE = ".";


    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USER_NAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_DEPT_ID = "currentUserDeptId";
    public static final String CONTEXT_KEY_USER_DEPT_NAME = "currentUserDeptName";
    public static final String CONTEXT_KEY_USER_ROLE_TYPE = "currentUserRoleType";
    public static final String CONTEXT_KEY_TOKEN = "currentToken";
//    public static final String CONTEXT_KEY_DING_ID = "currentDingId";

    /**
     * 过期时间 60秒
     */
    public static final int EXPIRE = 60;

    /**
     * 明文 自定义密码
     */
    public static final String JWT_SECRAT = "HJDHN123456";

    public static final Integer SHORT_UUID = 8;
}
