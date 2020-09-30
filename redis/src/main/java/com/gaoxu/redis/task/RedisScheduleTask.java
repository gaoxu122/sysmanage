package com.gaoxu.redis.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author gaoxu
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class RedisScheduleTask {

    @Autowired

    @Scheduled(cron = "0/5 * * * * ?")
    private void clearVisitsKey(){

    }
}
