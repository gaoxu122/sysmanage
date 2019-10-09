package com.framework.security.integral.api.model.ding;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jianghx
 * @create 2019/4/10 10:47
 **/

@Data
public class CorpTokenVO implements Serializable {

    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 钉钉企业id
     */
    private Long corpId;

    /**
     * 企业token
     */
    private String corpToken;

    /**
     * 过期时间
     */
    private Date expiredTime;

}
