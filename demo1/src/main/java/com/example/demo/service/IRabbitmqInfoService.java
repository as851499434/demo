package com.example.demo.service;

import com.example.demo.entity.RabbitmqInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liangfan
 * @since 2022-01-13
 */
public interface IRabbitmqInfoService extends IService<RabbitmqInfo> {
    /**
     * 发送消息
     * @param message
     */
    void sendMessage(String message);

}