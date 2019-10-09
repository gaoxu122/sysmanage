package com.framework.security.integral.core.bo.sys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jianghx
 * @create 2019/4/22 11:58
 **/
@Data
public class UserDetailBO implements Serializable {

    /**
     * 主键
     */
    @Id
    private Long id;


    private String name;

    /**
     * 是否已经激活，true表示已激活，false表示未激活
     */
    private Boolean active;

    /**
     * 头像信息
     */
    private String avatar;

    /**
     * 账号
     */
    private String userName;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;



    /**
     * 用户infoId
     */
    private Long userInfoId;




    /**
     * 工号
     */
    private String jobnumber;

    /**
     * 入职时间
     */
    @Column(name = "hired_date")
    private Date hiredDate;

    /**
     * 是否是管理员
     */
    @Column(name = "is_admin")
    private Boolean isAdmin;

    /**
     * unionid
     */
    private String unionid;

    /**
     * 业务用户id
     */
    @Column(name = "biz_userid")
    private String bizUserid;

    /**
     * 分机号
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 企业邮箱
     */
    @Column(name = "org_email")
    private String orgEmail;

    /**
     * 是否是老板
     */
    @Column(name = "is_boss")
    private Boolean isBoss;

    /**
     * 是否隐藏
     */
    @Column(name = "is_hide")
    private Boolean isHide;

    /**
     * 职位信息
     */
    private String position;

    /**
     * 是否是高管
     */
    @Column(name = "isSenior")
    private Boolean issenior;

    /**
     * 扩展属性
     */
    private String extattr;

    /**
     * 授权id
     */
    private Long userAuthId;

    /**
     * 工作地点
     */
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标识类型
     */
    @Column(name = "identity_type")
    private Integer identityType;

    /**
     * 标识，第三方登录标识，当用户名密码登录时候可以作为密码
     */
    private String identity;






}
