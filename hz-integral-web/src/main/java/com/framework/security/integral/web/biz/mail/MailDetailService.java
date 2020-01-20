package com.framework.security.integral.web.biz.mail;

import com.framework.security.integral.core.model.mail.Mail;
import com.framework.security.integral.core.model.mail.MailDetail;
import com.framework.security.integral.core.service.mail.MailService;
import com.framework.security.integral.web.vo.EmailVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaoxu
 */

@Service
@Slf4j
public class MailDetailService {

    @Autowired
    private MailService mailService;

    public void insertMailDetail(EmailVo emailVo) {
        Mail mail = new Mail();
        mail.setItem(emailVo.getItem());
        mail.setContent(emailVo.getEmailContent());
        mail.setGmtCreate(new Date());
        mail.setGmtModified(new Date());
        mail.setResponsePersons(emailVo.getResponsePerson());
        mail.setIsDelete(false);
        mailService.insertMail(mail);

        String responsePersons = mail.getResponsePersons();
        List<String> ids = Arrays.asList(responsePersons.split(",")).stream().map(s -> String.format(s.trim()))
                .collect(Collectors.toList());

        List<MailDetail> mailDetails = new ArrayList<>();
        ids.forEach(id -> {
            MailDetail mailDetail = new MailDetail();
            mailDetail.setMailId(mail.getId());
            if (null != emailVo.getSendDate()) {
                mailDetail.setSendDate(emailVo.getSendDate());
            }
            mailDetail.setSendDate(new Date());
            mailDetail.setResposePersonid(Integer.valueOf(id));
            mailDetails.add(mailDetail);
        });

        // 批量添加
        mailService.batchInsertMailDetail(mailDetails);
    }

}
