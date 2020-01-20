package com.framework.security.integral.core.service.mail;

import com.framework.security.integral.core.dao.mail.MailDetailMapper;
import com.framework.security.integral.core.dao.mail.MailMapper;
import com.framework.security.integral.core.model.mail.Mail;
import com.framework.security.integral.core.model.mail.MailDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author gaoxu
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MailService {

    @Autowired
    private MailMapper mailMapper;

    @Autowired
    private MailDetailMapper mailDetailMapper;

    /**
     * 插入邮件信息
     *
     * @param mail
     * @return
     */
    public Integer insertMail(Mail mail) {

        return this.mailMapper.insert(mail);
    }

    /**
     * 批量插入邮件详情
     *
     * @param mailDetails
     * @return
     */
    public Integer batchInsertMailDetail(List<MailDetail> mailDetails) {
        return this.mailDetailMapper.batchInsertMailDetail(mailDetails);
    }
}
