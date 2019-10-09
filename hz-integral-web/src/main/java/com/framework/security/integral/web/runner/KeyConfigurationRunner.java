package com.framework.security.integral.web.runner;

import com.framework.security.integral.web.configuration.UserAuthConfig;
import com.framework.security.integral.web.util.jwt.RsaKeyHelper;
import com.framework.security.integral.web.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author jianghx
 * @create 2019/4/1 17:14
 **/

@Configuration
public class KeyConfigurationRunner  implements CommandLineRunner {

    @Autowired
    private KeyConfiguration keyConfiguration;


    @Autowired
    private  UserAuthConfig userAuthConfig;
    @Override
    public void run(String... args) throws Exception {
        Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(userAuthConfig.getRsaSecret());
        keyConfiguration.setUserPriKey(keyMap.get("pri"));
        keyConfiguration.setUserPubKey(keyMap.get("pub"));
    }
}
