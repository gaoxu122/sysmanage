package com.framework.security.integral.web.constant;

/**
 * @author gaoxu
 * @date 2019-05-07 18:36
 */
public enum ReturnCode {


    /***系统设置返回码及其msg ：1000  -  1200***/
    /***       用户            ***/
    USER_ALREADY_EXISTS(1000, "用户已存在"),
    NAME_CANNOT_BE_EMPTY(1001, "用户名不存在"),
    PASSWORD_CANNOT_BE_EMPTY(1002, "密码不能为空"),


    /***       角色           ***/
    ROLE_NAME_NOT_EMPTY(1010, "角色名称不能为空"),


    /***       部门            ***/
    DEPARTMENT_NAME_NOT_EMPTY(1020, "部门名称不能为空"),
    SUPERIOR_DEPARTMENT_NOT_SELECTED(1021,"未选择上级部门"),

    /***       权限            ***/


    PARAMETER_INCOMING_ERROR(10001, "传入参数错误"),
    PLEASE_SELECT_FILE(11103, "请选择文件"),
    IMPORT_FILE_FAILED(11104, "导入文件失败"),
    UPDATE_FAILED(11000, "更新失败"),
    INSERT_FAILED(11001, "插入失败"),
    SELECT_FAILED(11002, "查询失败"),
    DELETE_FAILED(11003, "删除失败"),;


    /**
     * 返回码
     */

    private Integer code;
    /**
     * 返回信息
     */

    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg" + msg;
    }
}
