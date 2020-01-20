package com.framework.security.integral.web.biz.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author gaoxu
 */
@Async
public class TaskBiz {


    @Scheduled(cron = "0/5 * * * * *")
    public void executeNotice() {
        // 实现的业务逻辑
        
    }

}
