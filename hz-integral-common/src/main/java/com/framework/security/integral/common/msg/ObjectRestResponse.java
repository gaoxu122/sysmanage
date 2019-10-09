package com.framework.security.integral.common.msg;

import com.framework.security.integral.common.constant.ResultCode;
import com.framework.security.integral.common.vo.TableData;


/**
*ObjectRestResponse
 *
*@description
 *
*@author jianghx
*@create 2018/8/23 16:16
**/
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    boolean rel;


    /**
     * 返回成功数据
     * @return
     */
    public static ObjectRestResponse genJsonResultByOk() {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        return objectRestResponse;
    }


    /**
     *
     * @return
     */
    public static ObjectRestResponse success() {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        return objectRestResponse;
    }
    /**
     * 返回成功的数据
     *
     * @param data
     * @return
     */
    public static ObjectRestResponse success(Object data) {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setData(data);
        return objectRestResponse;
    }

    /**
     * 返回成功的数据
     *
     * @param data
     * @return
     */
    public static ObjectRestResponse genJsonResultByOk(Object data) {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setData(data);
        return objectRestResponse;
    }

    /**
     * 返回失败数据
     * @param errorCode
     * @param errorMessage
     * @return
     */
    public static ObjectRestResponse failure(int errorCode, String errorMessage) {
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(errorCode);
        objectRestResponse.setMessage(errorMessage);
        return objectRestResponse;
    }

    /**
     * 返回失败code
     * @param errorCode
     * @return
     */
    public static ObjectRestResponse failure(int errorCode) {
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(errorCode);
        objectRestResponse.setMessage("failure");
        return objectRestResponse;
    }

    /**
     * 返回列表类型数据
     * @param total
     * @param data
     * @return
     */
    public static ObjectRestResponse genTableResult(long total,Object data) {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        TableData tableData = new  TableData(total, data);
        objectRestResponse.setData(new TableData(total, data));
        return objectRestResponse;
    }


    /**
     *
     * @param rel
     * @return
     */
    public static ObjectRestResponse genJsonResultOfRel(boolean rel) {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setRel(rel);
        return objectRestResponse;
    }

    /**
     *
     * @param rel
     * @param data
     * @return
     */
    public static ObjectRestResponse genJsonResultOfRelAndData(boolean rel,Object data) {
        ResultCode codeOk = ResultCode.SUCCESS;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setRel(rel);
        objectRestResponse.setData(data);
        return objectRestResponse;
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}
