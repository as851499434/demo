package com.example.demo2.service;

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
    Integer sendMessage(String message);

}
