package com.framework.security.integral.common.context;

import com.framework.security.integral.common.constant.CommonConstants;
import com.framework.security.integral.common.util.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
*BaseContextHandler
 *
*用于存储当前会话用户基本信息
 *
*@author jianghx
*@create 2018/8/21 12:04
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

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static Long getUserID(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return Long.valueOf(returnObjectValue(value));
    }
    public static String getBizUserID(){
        Object value = get(CommonConstants.CONTEXT_KEY_BIZ_USER_ID);
        return returnObjectValue(value);
    }

    public static String getUserName(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return returnObjectValue(value);
    }

    public static String getName(){
        Object value = get(CommonConstants.CONTEXT_KEY_NAME);
        return returnObjectValue(value);
    }

    public static String getDingId(){
        Object value = get(CommonConstants.CONTEXT_KEY_DING_ID);
        return returnObjectValue(value);
    }

    public static String getRoleId(){
        Object value = get(CommonConstants.CONTEXT_KEY_ROLE_ID);
        return StringHelper.getObjectValue(value);
    }

    public static Long getCorpId(){
        Object value = get(CommonConstants.CONTEXT_KEY_CORP_ID);
        return Long.valueOf(returnObjectValue(value));
    }
    public static String getBizCorpId(){
        Object value = get(CommonConstants.CONTEXT_KEY_BIZ_CORP_ID);
        return StringHelper.getObjectValue(value);
    }
    public static String getAgentId(){
        Object value = get(CommonConstants.CONTEXT_KEY_AGENT_ID);
        return StringHelper.getObjectValue(value);
    }

    public static String getToken(){
        Object value = get(CommonConstants.CONTEXT_KEY_TOKEN);
        return StringHelper.getObjectValue(value);
    }
    public static void setToken(String token){set(CommonConstants.CONTEXT_KEY_TOKEN,token);}

    public static void setName(String name){set(CommonConstants.CONTEXT_KEY_USER_NAME,name);}

    public static void setUserId(Long userId){
        set(CommonConstants.CONTEXT_KEY_USER_ID,userId);
    }
    public static void setDingId(String dingId){
        set(CommonConstants.CONTEXT_KEY_DING_ID,dingId);
    }

    public static void setUserName(String userName){
        set(CommonConstants.CONTEXT_KEY_USER_NAME,userName);
    }

    public static void setAgentId(String agentId){
        set(CommonConstants.CONTEXT_KEY_AGENT_ID,agentId);
    }
    public static void setCorpId(Long corpId){
        set(CommonConstants.CONTEXT_KEY_CORP_ID,corpId);
    }

    public static void setBizCorpId(String bizCorpId){
        set(CommonConstants.CONTEXT_KEY_CORP_ID,bizCorpId);
    }
    public static void setBizUserId(String bizCorpId){
        set(CommonConstants.CONTEXT_KEY_CORP_ID,bizCorpId);
    }
    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest {
        private Logger logger = LoggerFactory.getLogger(UnitTest.class);

        @Test
        public void testSetContextVariable() throws InterruptedException {
            BaseContextHandler.set("test", "main");
            new Thread(()->{
                BaseContextHandler.set("test", "moo");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContextHandler.get("test"), "moo");
                logger.info("thread one done!");
            }).start();
            new Thread(()->{
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
