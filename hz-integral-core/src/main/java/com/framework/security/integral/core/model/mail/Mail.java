package com.framework.security.integral.core.model.mail;

import java.util.Date;
import javax.persistence.*;

public class Mail {
    /**
     * 邮件id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 发送人id
     */
    @Column(name = "send_person")
    private Integer sendPerson;

    /**
     * 接收人ids
     */
    @Column(name = "response_persons")
    private String responsePersons;

    /**
     * 主题
     */
    private String item;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

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
     * 获取邮件id
     *
     * @return id - 邮件id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置邮件id
     *
     * @param id 邮件id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取发送人id
     *
     * @return send_person - 发送人id
     */
    public Integer getSendPerson() {
        return sendPerson;
    }

    /**
     * 设置发送人id
     *
     * @param sendPerson 发送人id
     */
    public void setSendPerson(Integer sendPerson) {
        this.sendPerson = sendPerson;
    }

    /**
     * 获取接收人ids
     *
     * @return response_persons - 接收人ids
     */
    public String getResponsePersons() {
        return responsePersons;
    }

    /**
     * 设置接收人ids
     *
     * @param responsePersons 接收人ids
     */
    public void setResponsePersons(String responsePersons) {
        this.responsePersons = responsePersons;
    }

    /**
     * 获取主题
     *
     * @return item - 主题
     */
    public String getItem() {
        return item;
    }

    /**
     * 设置主题
     *
     * @param item 主题
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取是否删除
     *
     * @return is_delete - 是否删除
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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