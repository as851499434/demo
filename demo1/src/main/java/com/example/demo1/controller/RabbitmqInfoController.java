package com.example.demo1.controller;


import com.commons.demo_commons.entity.CommonResult;
import com.commons.demo_commons.entity.RabbitmqInfo;
import com.example.demo1.mapper.RabbitmqInfoMapper;
import com.example.demo1.service.IRabbitmqInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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

    @Resource
    RabbitmqInfoMapper rabbitmqInfoMapper;

    /**
     * 生产者
     */
    @ApiOperation(value = "生产者")
    @PostMapping("/sendMessage")
    @ResponseBody
    public Map send(String message)
    {
        Map<String, String> map = null;
        try {
            iRabbitmqInfoService.sendMessage(message);
            map = new HashMap<>();
            map.put("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 创建
     */
    @ApiOperation(value = "创建订单")
    @PostMapping("/createPayment")
    @ResponseBody
    public CommonResult createPayment(String message)
    {
        try {
            iRabbitmqInfoService.createPayment(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CommonResult();
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询订单")
    @GetMapping("/getPayment")
    @ResponseBody
    public CommonResult getPayment(String id)
    {
        CommonResult com = null;
        try {
            RabbitmqInfo rabbitmqInfo = rabbitmqInfoMapper.selectById(id);
            com = new CommonResult(200, rabbitmqInfo.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return com;
    }

}
