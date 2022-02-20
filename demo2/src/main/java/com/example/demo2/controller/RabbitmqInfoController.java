package com.example.demo2.controller;


import com.commons.demo_commons.entity.CommonResult;
import com.example.demo2.service.IRabbitmqInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    public CommonResult send(String message)
    {
        CommonResult com = null;
        try {
            Integer i = iRabbitmqInfoService.sendMessage(message);
            if (i > 0) {
                com = new CommonResult<>(200,"插入成功");
            } else {
                com = new CommonResult(400, "插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            com = new CommonResult(404, "异常");
        }
        return com;
    }

}
