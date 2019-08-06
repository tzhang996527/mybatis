package com.example.demomybatis.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.example.demomybatis.App;
import com.example.demomybatis.mq.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 50000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

    //@Scheduled(fixedRate = 5000)
    public void sendMsg2MQ() throws InterruptedException {
        log.info("MQ logs>>>>>>>>>>>>");
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(App.topicExchangeName, "foo.bar.baz",
                "Hello from RabbitMQ!" + dateFormat.format(new Date()));
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}