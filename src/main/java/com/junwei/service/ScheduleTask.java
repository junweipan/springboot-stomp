package com.junwei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleTask {

    @Autowired
    private SimpMessagingTemplate template;

    // this will send a message to an endpoint on which a client can subscribe
    // 5000 millisecond
    @Scheduled(fixedRate = 10000)
    public void trigger() {
        this.template.convertAndSend("/topic/auto-messages", "Date: " + new Date());
    }

}
