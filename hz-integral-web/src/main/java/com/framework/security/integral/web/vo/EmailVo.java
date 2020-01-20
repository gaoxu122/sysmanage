package com.framework.security.integral.web.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author gaoxu
 */
@Data
public class EmailVo {

    private String item;
    private String responsePerson;
    private String emailContent;
    private String nickName;
    private String CC;
    private String imag;
    private String sendPerson;
    private Date sendDate;

}
