package com.framework.security.integral.core.dao.mail;

import com.framework.security.integral.core.model.mail.MailDetail;
import org.springframework.beans.factory.annotation.Value;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author gaoxu
 */
public interface MailDetailMapper extends Mapper<MailDetail> {

    /**
     * 批量添加邮件详情
     *
     * @param mailDetails
     * @return
     */
    Integer batchInsertMailDetail(@Value("mailDetails") List<MailDetail> mailDetails);
}