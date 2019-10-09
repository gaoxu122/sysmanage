package com.framework.security.integral.web.SchedulerTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author gaoxu
 * @date 2019-05-16 11:04
 */
@Slf4j
@Async
@Component
public class IntegralSchedulerTask {


//    @Scheduled(cron = "0 0 0 * * *")
//    public void scheduled() {
//        enterpriseInfoBiz.updateCorpStatus();
//    }

}
