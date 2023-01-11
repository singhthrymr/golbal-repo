package com.practice.cronJob;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Configuration
@EnableScheduling
public class CronTrigger {
    @Scheduled(cron = "* * * * * *")
    public void methodPrint(){
        System.out.println("dilip practiced git");
    }
}
