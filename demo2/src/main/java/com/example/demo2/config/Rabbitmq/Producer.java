package com.example.demo2.config.Rabbitmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${rabbitmq.exchange}")
    String exchange;
    @Value("${rabbitmq.routing.key}")
    String routingKey;

    public void send(String s) {
        amqpTemplate.convertAndSend(exchange,routingKey,s);
        log.info("发送id: {}", s);
    }

}

