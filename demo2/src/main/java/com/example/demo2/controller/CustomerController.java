package com.example.demo2.controller;


import com.commons.demo_commons.entity.CommonResult;
import com.example.demo2.service.IRabbitmqInfoService;
import com.example.demo2.utils.HttpClientUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangfan
 * @since 2022-01-13
 */
@Controller
@Slf4j
@RequestMapping("")
public class CustomerController {

    public static final String URL = "http://localhost:8001/rabbitmq-info";
    public static final String URL2 = "http://DEMO";

    @Resource
    IRabbitmqInfoService iRabbitmqInfoService;

    @Resource
    RestTemplate restTemplate;

    /**
     * 创建订单
     */
    @ApiOperation(value = "创建订单")
    @PostMapping("/customer/sendMessage")
    @ResponseBody
    public CommonResult send(String message)
    {
        log.info("创建订单{}",message);
        HttpClientUtil.doPostJson(URL + "/createPayment", message);
        return new CommonResult<>();
    }

    /**
     * 查询订单
     */
    @ApiOperation(value = "查询订单")
    @GetMapping("/customer/getMessage")
    public CommonResult getMessage(String id)
    {
        log.info("查询订单:{}",id);
        log.info("查询订单:{}",URL2 + "/getPayment?id=" + id);

        restTemplate.getForObject(URL2 + "/getPayment?id=" + id, String.class);
        return new CommonResult();
    }

}
