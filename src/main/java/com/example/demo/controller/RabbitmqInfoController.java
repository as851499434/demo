package com.example.demo.controller;


import com.example.demo.config.Rabbitmq.Producer;
import com.example.demo.service.IRabbitmqInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
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

}
