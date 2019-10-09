package com.framework.security.integral.common.util;

/**
*StringHelper
 *
*@description
 *
*@author jianghx
*@create 2018/8/23 16:16
**/
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
