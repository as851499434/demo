package com.example.demo1.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.commons.demo_commons.entity.RabbitmqInfo;

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

    /**
     * 创建订单
     * @param
     */
    void createPayment(String message);

}
