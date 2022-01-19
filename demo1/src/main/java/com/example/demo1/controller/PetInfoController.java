package com.example.demo1.controller;


import com.example.demo1.entity.PetInfo;
import com.example.demo1.mapper.PetInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 宠物信息表 前端控制器
 * </p>
 *
 * @author liangfan
 * @since 2021-12-06
 */
@Controller
@Api(tags = "宠物管理")
public class PetInfoController {

    @Resource
    PetInfoMapper petInfoMapper;


    @ApiOperation(value = "登录页")
    @GetMapping("/index")
    public String petInfo()
    {
        return  "index";
    }


    /**
     * 新增保存宠物
     */
    @ApiOperation(value = "新增保存宠物页面")
    @PostMapping("/add")
    @ResponseBody
    public Map add()
    {
        Date date = new Date();
        DateFormat df3 = DateFormat.getDateTimeInstance();
        String format = df3.format(date);

        Map<String, String> map = new HashMap<>();
        PetInfo petInfo = new PetInfo();
        petInfo.setId(1);
        petInfo.setPetName("猪猪侠");
        petInfo.setProviderId(23);
        petInfo.setCreateTime(date);
        petInfo.setUpdateTime(format);
        petInfoMapper.updateById(petInfo);
        map.put("success", "1");
        map.put("msg", "添加用户成功");
        return map;
    }



}
