package com.framework.security.integral.api.enums;

import java.util.ArrayList;
import java.util.List;

import com.framework.security.integral.common.exception.BaseException;
/**
*EnumStatus
 *
*@description
 *
*@author jianghx
*@create 2019/4/22 16:26
**/
public enum EnumStatus {

    user_auth_type_ding(1, "钉钉授权", StatusType.user_auth_type),
    corp_auth_status_yes(0, "企业已授权", StatusType.corp_auth_status),
    corp_auth_status_no(1, "企业未授权", StatusType.corp_auth_status),
    sys_flag_yes(1, "是", StatusType.user_auth_type)

    ;
    private int id;

    private String describe;

    private StatusType type;


    EnumStatus(Integer id, String describe, StatusType type) {
        this.id = id;
        this.describe = describe;
        this.type = type;
    }

    /**
     * 获取状态ID
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 获取状态ID
     *
     * @return
     */
    public int getIntValue() {
        return this.getId().intValue();
    }

    /**
     * 获取状态描述
     *
     * @return
     */
    public String getDescribe() {
        return describe;
    }

    public StatusType getType() {
        return type;
    }

    /**
     * 根据类型（业务类型，枚举分类）返回枚举列表，（springMvc对枚举的解析不包含枚举中定义的成员，
     * 需要返回json数组时，建议调用getJsonByType方法）
     *
     * @param type
     * @return
     */
    public static List<EnumStatus> getByType(StatusType type) {
        List<EnumStatus> statusList = new ArrayList<EnumStatus>();
        for (EnumStatus status : EnumStatus.values()) {
            if (status.type == type) {
                statusList.add(status);
            }
        }
        return statusList;
    }

    /**
     * 根据类型（业务类型，枚举分类,id）返回枚举描述名称
     *
     * @param type
     * @return
     */
    public static String getDescByType(StatusType type, Integer id) {
        for (EnumStatus status : EnumStatus.values()) {
            if (status.type == type && status.id == id) {
                return status.describe;
            }
        }
        return "";
    }

    /**
     * 根据类型（业务类型，枚举分类,id）返回枚举
     *
     * @param type
     * @return
     */
    public static EnumStatus getEnumByType(StatusType type, Integer id) {
        for (EnumStatus status : EnumStatus.values()) {
            if (status.type == type && status.id == id) {
                return status;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "{\"id\":\"" + this.id + "\",\"describe\":\"" + this.describe + "\"}";
    }

    /**
     *
     * @param prefix
     * @param id
     * @return
     * @throws BaseException
     */
    public static EnumStatus getStatus(String prefix, Integer id)
            throws BaseException {
        for (EnumStatus status : EnumStatus.values()) {
            if (status.name().startsWith(prefix)
                    && status.getId().intValue() == id.intValue()) {
                return status;
            }
        }
        throw new BaseException("类型错误：" + prefix + "无ID为" + id + "的相关类型！");
    }
}
