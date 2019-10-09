package com.framework.security.integral.api.model.corp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jianghx
 * @create 2019/4/10 11:45
 **/

@Data
public class CorpVo implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 企业名称
     */
    private String corpName;


    /**
     * 企业logo链接
     */
    private String corpLogoUrl;

    /**
     * 企业负责人
     */
    private String boss;

    /**
     * 企业联系方式
     */
    private String contact;


    /**
     * 企业状态
     */
    private Integer status;


    /**
     * 来源类型钉钉:1
     */
    private Integer sourceType;

    /**
     * 来源标识
     */
    private String identity;

}
