package com.example.demo1_2.service;


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
     * 创建订单
     * @param
     */
    void createPayment(String message);

}
