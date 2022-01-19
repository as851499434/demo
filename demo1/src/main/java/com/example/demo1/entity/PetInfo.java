package com.example.demo1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 宠物信息表
 * </p>
 *
 * @author liangfan
 * @since 2021-12-06
 */
@Data
@TableName("tbl_pet_info")
@ApiModel(value = "PetInfo对象", description = "宠物信息表")
public class PetInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "主人id")
    private Integer masterId;

    @ApiModelProperty("宠物名字")
    private String petName;

    @ApiModelProperty("宠物种类")
    private String petType;

    @ApiModelProperty("宠物性别")
    private Integer petSex;

    @ApiModelProperty("宠物年龄")
    private Integer petAge;

    @ApiModelProperty("宠物信息类型 4 店养宠物 1 医疗宠物 2 销售宠物 3寄养宠物 5 宠物服务")
    private Integer petInfoType;

    @ApiModelProperty("照片")
    private String photo;

    @ApiModelProperty("备注")
    private String remake;

    @ApiModelProperty("删除状态 0 未删除 1 已删除")
    private String delStatus;

    private Integer providerId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private String updateTime;


}
