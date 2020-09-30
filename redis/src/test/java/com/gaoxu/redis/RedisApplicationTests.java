package com.gaoxu.redis;

import com.gaoxu.redis.servise.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private LoginService loginService;

    @Test
    void contextLoads() throws Exception {
        loginService.visits("123");
    }


}
