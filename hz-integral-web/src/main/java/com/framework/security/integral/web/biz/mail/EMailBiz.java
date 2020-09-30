package com.framework.security.integral.web.biz.mail;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.dao.mail.MailMapper;
import com.framework.security.integral.core.model.mail.Mail;
import com.framework.security.integral.core.model.sys.User;
import com.framework.security.integral.core.service.sys.UserService;
import com.framework.security.integral.web.biz.SendMailService;
import com.framework.security.integral.web.constant.ReturnCode;
import com.framework.security.integral.web.vo.EmailVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * @author gaoxu
 */
@Service
@Slf4j
public class EMailBiz extends BaseBiz<MailMapper, Mail> {


    @Autowired
    private UserService userService;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private MailDetailService mailDetailService;


    /**
     * 发送邮件
     *
     * @param emailVo
     * @return
     */
    public ObjectRestResponse sendEmail(EmailVo emailVo) {

        log.debug("邮件参数：{}", emailVo.toString());

        if (StringUtils.isBlank(emailVo.getItem())) {
            return ObjectRestResponse.failure(ReturnCode.MAIL_ITEM_IS_EMPTY.getCode(), ReturnCode.MAIL_ITEM_IS_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(emailVo.getResponsePerson())) {
            return ObjectRestResponse.failure(ReturnCode.MAIL_RESPONSE_IS_EMPTY.getCode(), ReturnCode.MAIL_RESPONSE_IS_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(emailVo.getItem())) {
            return ObjectRestResponse.failure(ReturnCode.MAIL_CONTENT_IS_EMPTY.getCode(), ReturnCode.MAIL_CONTENT_IS_EMPTY.getMsg());
        }

        List<User> users = userService.selectUserByIds(emailVo.getResponsePerson());
        try {
            // 发送邮件
            Optional.of(users)
                    .orElse(new ArrayList<>())
                    .forEach(user -> sendMailService.sendMail(emailVo.getItem(), user.getUserName(), user.getEmail(), emailVo.getEmailContent()));

            // 插入数据
            mailDetailService.insertMailDetail(emailVo);
        } catch (Exception e) {
            throw new BaseException(ReturnCode.SEND_MAIL_FAIL.getMsg(), ReturnCode.SEND_MAIL_FAIL.getCode());
        }

        return ObjectRestResponse.success();
    }

    /**
     * 获取发送邮件
     * 模糊查询 暂时不做
     *
     * @return
     */
    public ObjectRestResponse selectEmailDetail(Query query) {

        Example example = new Example(Mail.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("isDelete", Collections.singleton(true));
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Mail> mail = this.mapper.selectByExample(example);

        return ObjectRestResponse.success(mail);
    }


}
