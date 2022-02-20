package com.example.demo1.service.impl;


import com.commons.demo_commons.entity.PetInfo;
import com.example.demo1.mapper.PetInfoMapper;
import com.example.demo1.service.IPetInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
