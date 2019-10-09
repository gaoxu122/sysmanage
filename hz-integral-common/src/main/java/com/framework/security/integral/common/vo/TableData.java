package com.framework.security.integral.common.vo;

/**
 * @author jianghx
 * @create 2018/9/3 11:49
 **/
public class TableData {

    long total;
    Object data;

    public TableData(long total, Object data) {
        this.total = total;
        this.data = data;
    }

    public TableData() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
