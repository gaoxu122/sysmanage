package com.framework.security.integral.web.controller;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.Query;
import com.framework.security.integral.core.dao.mail.MailMapper;
import com.framework.security.integral.web.biz.mail.EMailBiz;
import com.framework.security.integral.web.vo.EmailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @author gaoxu
 */
@RestController
@RequestMapping("/email")
public class EmailController extends BaseController<EMailBiz, MailMapper> {

    @Autowired
    private EMailBiz eMailBiz;

    @PostMapping("/sendEmail")
    public ObjectRestResponse sendEmail(@RequestBody EmailVo emailVo) {
        return eMailBiz.sendEmail(emailVo);
    }

    @GetMapping("/selectMail")
    public ObjectRestResponse selectEmail(@RequestBody Map<String, Object> params) {

        Query query = new Query(params);
        return eMailBiz.selectEmailDetail(query);
    }
}
