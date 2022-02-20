package com.example.demo1_2.controller;


import com.commons.demo_commons.entity.CommonResult;
import com.example.demo1_2.service.IRabbitmqInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangfan
 * @since 2022-01-13
 */
@Controller
@RequestMapping("/rabbitmq-info")
public class RabbitmqInfoController {
    @Resource
    IRabbitmqInfoService iRabbitmqInfoService;

    /**
     * 创建
     */
    @ApiOperation(value = "创建订单")
    @PostMapping("/createPayment")
    @ResponseBody
    public CommonResult createPayment(@RequestBody String message)
    {
        try {
            iRabbitmqInfoService.createPayment(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CommonResult();
    }

}
