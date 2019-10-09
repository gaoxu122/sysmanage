package com.huizhiframework.security.permissions.model.user;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_user_info")
public class UserInfoDO {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    private Long userid;

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

    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

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
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return userid - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取工号
     *
     * @return jobnumber - 工号
     */
    public String getJobnumber() {
        return jobnumber;
    }

    /**
     * 设置工号
     *
     * @param jobnumber 工号
     */
    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    /**
     * 获取入职时间
     *
     * @return hired_date - 入职时间
     */
    public Date getHiredDate() {
        return hiredDate;
    }

    /**
     * 设置入职时间
     *
     * @param hiredDate 入职时间
     */
    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * 获取是否是管理员
     *
     * @return is_admin - 是否是管理员
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置是否是管理员
     *
     * @param isAdmin 是否是管理员
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 获取unionid
     *
     * @return unionid - unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置unionid
     *
     * @param unionid unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 获取业务用户id
     *
     * @return biz_userid - 业务用户id
     */
    public String getBizUserid() {
        return bizUserid;
    }

    /**
     * 设置业务用户id
     *
     * @param bizUserid 业务用户id
     */
    public void setBizUserid(String bizUserid) {
        this.bizUserid = bizUserid;
    }

    /**
     * 获取分机号
     *
     * @return tel - 分机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置分机号
     *
     * @param tel 分机号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取企业邮箱
     *
     * @return org_email - 企业邮箱
     */
    public String getOrgEmail() {
        return orgEmail;
    }

    /**
     * 设置企业邮箱
     *
     * @param orgEmail 企业邮箱
     */
    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    /**
     * 获取是否是老板
     *
     * @return is_boss - 是否是老板
     */
    public Boolean getIsBoss() {
        return isBoss;
    }

    /**
     * 设置是否是老板
     *
     * @param isBoss 是否是老板
     */
    public void setIsBoss(Boolean isBoss) {
        this.isBoss = isBoss;
    }

    /**
     * 获取是否隐藏
     *
     * @return is_hide - 是否隐藏
     */
    public Boolean getIsHide() {
        return isHide;
    }

    /**
     * 设置是否隐藏
     *
     * @param isHide 是否隐藏
     */
    public void setIsHide(Boolean isHide) {
        this.isHide = isHide;
    }

    /**
     * 获取职位信息
     *
     * @return position - 职位信息
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位信息
     *
     * @param position 职位信息
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取是否是高管
     *
     * @return isSenior - 是否是高管
     */
    public Boolean getIssenior() {
        return issenior;
    }

    /**
     * 设置是否是高管
     *
     * @param issenior 是否是高管
     */
    public void setIssenior(Boolean issenior) {
        this.issenior = issenior;
    }

    /**
     * 获取扩展属性
     *
     * @return extattr - 扩展属性
     */
    public String getExtattr() {
        return extattr;
    }

    /**
     * 设置扩展属性
     *
     * @param extattr 扩展属性
     */
    public void setExtattr(String extattr) {
        this.extattr = extattr;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modified - 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取工作地点
     *
     * @return work_place - 工作地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置工作地点
     *
     * @param workPlace 工作地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}