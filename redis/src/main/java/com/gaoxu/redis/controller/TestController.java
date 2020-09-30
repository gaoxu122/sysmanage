package com.gaoxu.redis.controller;

import com.gaoxu.redis.servise.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxu
 */
@RestController
@RequestMapping(value = "/www")
public class TestController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/www")
    public String test() throws Exception {

        return null;
    }
}
