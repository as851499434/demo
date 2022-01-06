package com.example.demo.config.Rabbitmq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: liangfan
 * @Date: 2021-12-29 16:23
 * @Description: 消费者
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue}", containerFactory = "singleListenerContainer")
    public void receive(String message) {
        log.info("消费者拿到消息: {}", message);
    }
}

