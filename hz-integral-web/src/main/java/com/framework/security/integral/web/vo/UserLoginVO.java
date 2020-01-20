package com.framework.security.integral.web.vo;

import lombok.Data;

/**
 * @author gaoxu
 * @date 2019-07-10 18:22
 */
@Data
public class UserLoginVO {

    private String userName;
    private String password;
    private Integer sex;
    private String email;
    private Long tel;

}
