package com.commons.demo_commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liangfan
 * @since 2022-01-13
 */
@Data
@TableName("tbl_rabbitmq_info")
@ApiModel(value = "RabbitmqInfo对象", description = "")
public class RabbitmqInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("交换机")
    private String exchange;

    @ApiModelProperty("key")
    private String routingKey;

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("消息状态 0 未消费 1 已消费")
    private Integer status;

    private Integer providerId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}
