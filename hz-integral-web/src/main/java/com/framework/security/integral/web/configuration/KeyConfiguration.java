package com.framework.security.integral.web.configuration;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
*KeyConfiguration
 *
*@description
 *
*@author jianghx
*@create 2018/8/30 11:51
**/
@Configuration
@Data
public class KeyConfiguration {
    private byte[] userPubKey;
    private byte[] userPriKey;
}
