package com.example.demo.config.Rabbitmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author: liangfan
 * @Date: 2021-12-29 16:22
 * @Description: 生产者
 */
@Component
@Slf4j
public class Producer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String s) {
        log.info("发送的消息: {}", s);
        amqpTemplate.convertAndSend("amq.direct","direct",s);
        log.info("发送完成");
    }

}

