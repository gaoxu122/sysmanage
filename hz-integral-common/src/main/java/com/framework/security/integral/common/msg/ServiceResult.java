package com.framework.security.integral.common.msg;

import java.io.Serializable;

/**
 *service层返回对象列表封装
 * @author gaoxu
 * @param <T>
 */
public class ServiceResult<T>  implements Serializable{

    private boolean success = false;

    private int code;

    private String message;

    private T result;

    private ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.result = result;
        item.code = 0;
        item.message = "success";
        return item;
    }

    public static <T> ServiceResult<T> failure(int errorCode, String errorMessage) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = errorMessage;
        return item;
    }

    public static <T> ServiceResult<T> failure(int errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = "failure";
        return item;
    }

    public boolean hasResult() {
        return result != null;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
