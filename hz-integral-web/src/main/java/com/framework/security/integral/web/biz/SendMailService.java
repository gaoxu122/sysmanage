package com.framework.security.integral.web.biz;

import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.web.configuration.EmailConfiguration;
import com.framework.security.integral.web.util.EmailUtil;
import com.framework.security.integral.web.util.SendMailException;
import com.framework.security.integral.web.vo.EmailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送邮件 根据各种参数 进行区分
 * 用服务判断的方式进行优化 <后期处理></后期处理>
 *
 * @author gaoxu
 */

@Service
@Slf4j
public class SendMailService {

    @Autowired
    private EmailConfiguration emailConfiguration;

    /**
     * 发送邮件
     *
     * @param item
     * @param nickName
     * @param responseId
     * @param content
     * @return
     */
    public void sendMail(String item, String nickName, String responseId, String content) {

        emailConfiguration.createEmailConfig();
        try {
            EmailUtil.subject(item)
                    .from(nickName)
                    .to(responseId)
                    .text(content)
                    .send();
        } catch (SendMailException e) {
            e.printStackTrace();
        }
    }

}
