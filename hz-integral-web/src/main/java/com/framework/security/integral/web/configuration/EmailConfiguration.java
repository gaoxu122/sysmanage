package com.framework.security.integral.web.configuration;


import com.framework.security.integral.web.util.EmailUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author gaoxu
 */
@Configuration
@Data
public class EmailConfiguration {

    @Value("${spring.email.userName}")
    private String userName;
    @Value("${spring.email.passWord}")
    private String passWord;


    public void createEmailConfig() {

        EmailUtil.config(EmailUtil.SMTP_QQ(false), userName, passWord);
    }

}
