package com.framework.security.integral.web.controller;

import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.web.annotation.IgnoreUserToken;
import com.framework.security.integral.web.biz.LoginBiz;
import com.framework.security.integral.web.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录控制器
 *
 * @author gaoxu
 * @create 2019/7/8 16:22
 **/
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {


    @Autowired
    private LoginBiz loginBiz;

    /**
     *  1. 首先检查用户输入的用户名是否存在(当用户输入用户名时) 并返回检查状态
     *  2. 登录
     *  3. 登录完成发送请求获得该用户的权限.
     *
     * @return
     */
    @IgnoreUserToken
    @PostMapping(value = "/login_in")
    public ObjectRestResponse login(@RequestBody UserLoginVO user) {

        return loginBiz.login(user);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @IgnoreUserToken
    @PostMapping(value = "/registered")
    public ObjectRestResponse registered(@RequestBody UserLoginVO user) {
        return loginBiz.registered(user);
    }
}
