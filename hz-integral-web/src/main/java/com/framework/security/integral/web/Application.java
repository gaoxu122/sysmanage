package com.framework.security.integral.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
*Application
 *
*@description
 *
*@author jianghx
*@create 2019/4/1 11:29
**/
@SpringBootApplication(scanBasePackages = "com.framework.security")
@MapperScan(basePackages={"com.framework.security.integral.core.dao",
		"com.framework.security.integral.permissions.dao"})
@EnableScheduling
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
