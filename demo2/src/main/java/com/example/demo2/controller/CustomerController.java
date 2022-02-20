package com.example.demo2.controller;


import com.commons.demo_commons.entity.CommonResult;
import com.example.demo2.service.IRabbitmqInfoService;
import com.example.demo2.utils.HttpClientUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    IRabbitmqInfoService iRabbitmqInfoService;

    /**
     * 生产者
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

}
