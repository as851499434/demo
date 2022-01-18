package com.example.demo.service.impl;


import cn.hutool.core.date.DateTime;
import com.example.demo.config.Rabbitmq.Producer;
import com.example.demo.entity.RabbitmqInfo;
import com.example.demo.mapper.RabbitmqInfoMapper;
import com.example.demo.service.IRabbitmqInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangfan
 * @since 2022-01-13
 */
@Service
@Slf4j
public class RabbitmqInfoServiceImpl extends ServiceImpl<RabbitmqInfoMapper, RabbitmqInfo> implements IRabbitmqInfoService {
    @Resource
    Producer producer;

    @Resource
    RabbitmqInfoMapper rabbitmqInfoMapper;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routing.key}")
    String routingKey;

    @Override
    public void sendMessage(String message) {
        RabbitmqInfo rabbitmqInfo = new RabbitmqInfo();
        rabbitmqInfo.setMessage(message);
        rabbitmqInfo.setExchange(exchange);
        rabbitmqInfo.setRoutingKey(routingKey);
        rabbitmqInfo.setCreateTime(new DateTime());
        int insert = rabbitmqInfoMapper.insert(rabbitmqInfo);
        if (insert == 1) {
            producer.send(rabbitmqInfo.getId().toString());
        } else {
            log.error("生产数据出错: {}", message);
        }

    }
}
