package com.huizhiframework.security.permissions.controller;

import com.framework.security.integral.common.msg.ObjectRestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianghx
 * @create 2019/4/19 17:17
 **/

@RestController
public class TestController {


    @RequestMapping("/test")
    public ObjectRestResponse test() {

        return ObjectRestResponse.success();
    }
}
