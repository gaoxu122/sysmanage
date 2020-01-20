package com.framework.security.integral.common.context;

import com.framework.security.integral.common.constant.CommonConstants;
import com.framework.security.integral.common.util.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * BaseContextHandler
 * <p>
 * 用于存储当前会话用户基本信息
 *
 * @author jianghx
 * @create 2018/8/21 12:04
 **/
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static Integer getUserID() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return Integer.valueOf(returnObjectValue(value));
    }

    public static String getUserName() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return returnObjectValue(value);
    }

    public static Integer getDeptId() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_DEPT_ID);
        return Integer.valueOf(returnObjectValue(value));
    }

    public static String getDeptName() {
        Object Value = get(CommonConstants.CONTEXT_KEY_USER_DEPT_NAME);
        return returnObjectValue(Value);
    }

    public static Integer getRoleId() {
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ROLE_TYPE);
        return Integer.valueOf(returnObjectValue(value));
    }

    public static String getToken() {
        Object value = get(CommonConstants.CONTEXT_KEY_TOKEN);
        return StringHelper.getObjectValue(value);
    }

    public static void setToken(String token) {
        set(CommonConstants.CONTEXT_KEY_TOKEN, token);
    }

//    public static void setName(String name) {
//        set(CommonConstants.CONTEXT_KEY_USER_NAME, name);
//    }

    public static void setUserId(Integer userId) {
        set(CommonConstants.CONTEXT_KEY_USER_ID, userId);
    }

    public static void setUserName(String userName) {
        set(CommonConstants.CONTEXT_KEY_USER_NAME, userName);
    }

    public static void setDeptId(Integer deptId) {
        set(CommonConstants.CONTEXT_KEY_USER_DEPT_ID, deptId);
    }

    public static void setDeptName(String deptName) {
        set(CommonConstants.CONTEXT_KEY_USER_DEPT_NAME, deptName);
    }

    public static void setRoleId(Integer roleId) {
        set(CommonConstants.CONTEXT_KEY_USER_ROLE_TYPE, roleId);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest {
        private Logger logger = LoggerFactory.getLogger(UnitTest.class);

        @Test
        public void testSetContextVariable() throws InterruptedException {
            BaseContextHandler.set("test", "main");
            new Thread(() -> {
                BaseContextHandler.set("test", "moo");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContextHandler.get("test"), "moo");
                logger.info("thread one done!");
            }).start();
            new Thread(() -> {
                BaseContextHandler.set("test", "moo2");
                assertEquals(BaseContextHandler.get("test"), "moo2");
                logger.info("thread two done!");
            }).start();

            Thread.sleep(5000);
            assertEquals(BaseContextHandler.get("test"), "main");
            logger.info("main one done!");
        }

    }
}
