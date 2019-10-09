package com.framework.security.integral.common.util;


import com.framework.security.integral.common.constant.CommonConstants;
import com.framework.security.integral.common.constant.CommonConstants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
*Query
 *
*查询参数
 *
*@author jianghx
*@create 2018/8/20 16:26
**/
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
    /**
     *页码
     */
    private int page = CommonConstants.PAGE;

    /**
     * 页数
     */
    private int limit = CommonConstants.PAGE_SIZE;

    public Query(Map<String, Object> params){
        this.putAll(params);
        //分页参数
        if(params.get(CommonConstants.RQUEST_PAGE)!=null) {
            this.page = Integer.parseInt(params.get(CommonConstants.RQUEST_PAGE).toString());
        }
        if(params.get(CommonConstants.RQUEST_LIMIT)!=null) {
            this.limit = Integer.parseInt(params.get(CommonConstants.RQUEST_LIMIT).toString());
        }
        this.remove(CommonConstants.RQUEST_PAGE);
        this.remove(CommonConstants.RQUEST_LIMIT);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
