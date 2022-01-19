package com.example.demo1.config.Rabbitmq;

import com.example.demo1.entity.RabbitmqInfo;
import com.example.demo1.mapper.RabbitmqInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: liangfan
 * @Date: 2021-12-29 16:23
 * @Description: 消费者
 */
@Component
@Slf4j
public class Consumer {
    private static final Integer SUCCESS = 1;

    @Resource
    RabbitmqInfoMapper rabbitmqInfoMapper;

    @RabbitListener(queues = "direct" , containerFactory = "multiListenerContainer")
    public void receive(String id) {
        RabbitmqInfo rabbitmqInfo = null;
        try {
            rabbitmqInfo = rabbitmqInfoMapper.selectById(id);
            rabbitmqInfo.setStatus(SUCCESS);
            rabbitmqInfo.setUpdateTime(new Date());
            rabbitmqInfoMapper.updateById(rabbitmqInfo);
            log.info("消费者拿到消息: {} 交换机是: {}", rabbitmqInfo.getMessage(), rabbitmqInfo.getExchange());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("id为 {} 的数据消费失败", id);
        }

    }
}

