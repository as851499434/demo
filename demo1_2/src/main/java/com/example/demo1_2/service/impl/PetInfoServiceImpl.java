package com.example.demo1_2.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.commons.demo_commons.entity.PetInfo;
import com.example.demo1_2.mapper.PetInfoMapper;
import com.example.demo1_2.service.IPetInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宠物信息表 服务实现类
 * </p>
 *
 * @author liangfan
 * @since 2021-12-06
 */
@Service
public class PetInfoServiceImpl extends ServiceImpl<PetInfoMapper, PetInfo> implements IPetInfoService {

}
