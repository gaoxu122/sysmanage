package com.framework.security.integral.core.model.mail;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mail_detail")
public class MailDetail {
    /**
     * 邮件详情id
     */
    @Id
    private Integer id;

    /**
     * 邮件id
     */
    @Column(name = "mail_id")
    private Integer mailId;

    /**
     * 接受者id
     */
    @Column(name = "respose_personId")
    private Integer resposePersonid;

    /**
     * 邮件发送时间
     */
    @Column(name = "send_date")
    private Date sendDate;

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
     * 获取邮件详情id
     *
     * @return id - 邮件详情id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置邮件详情id
     *
     * @param id 邮件详情id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取邮件id
     *
     * @return mail_id - 邮件id
     */
    public Integer getMailId() {
        return mailId;
    }

    /**
     * 设置邮件id
     *
     * @param mailId 邮件id
     */
    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    /**
     * 获取接受者id
     *
     * @return respose_personId - 接受者id
     */
    public Integer getResposePersonid() {
        return resposePersonid;
    }

    /**
     * 设置接受者id
     *
     * @param resposePersonid 接受者id
     */
    public void setResposePersonid(Integer resposePersonid) {
        this.resposePersonid = resposePersonid;
    }

    /**
     * 获取邮件发送时间
     *
     * @return send_date - 邮件发送时间
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * 设置邮件发送时间
     *
     * @param sendDate 邮件发送时间
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
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
}