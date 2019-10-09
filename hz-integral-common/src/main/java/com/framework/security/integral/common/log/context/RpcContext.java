package com.framework.security.integral.common.log.context;

import java.util.UUID;

/**
*RpcContext
 *
*@description
 *
*@author jianghx
*@create 2019/4/2 14:22
**/
public class RpcContext {
    public static ThreadLocal<String> traceId = new ThreadLocal<String>(){
        @Override
        public String get() {
            if(null ==  super.get()){
                super.set(UUID.randomUUID().toString());
            }
            return super.get();
        }
    };
}
