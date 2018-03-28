package com.example.demo.manage;

import com.example.demo.service.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

    protected final static Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    private IRedisService redisService;

    @Scheduled(cron="0 59 23 * * ?")
    public void updateViewCount() {

        redisService.get("count");
        redisService.set("counts",redisService.get("count"));
        redisService.expire("counts",24*60*60);
    }
}
