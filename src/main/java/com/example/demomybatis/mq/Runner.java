package com.example.demomybatis.mq;

import java.util.concurrent.TimeUnit;

import com.example.demomybatis.App;
import com.example.demomybatis.job.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
//        log.info("MQ logs>>>>>>>>>>>>");
//        System.out.println("Sending message...");
//        rabbitTemplate.convertAndSend(App.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}
