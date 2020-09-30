package com.framework.security.integral.core.vo;


import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author gaoxu
 */
@Data
public class UserRoleVO implements Serializable {

    private Integer id;

    private String userName;


}
