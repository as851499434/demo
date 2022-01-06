package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;

/**
 * 宠物表 tbl_pet_info
 * 
 * @author meimiao
 * @date 2021-04-10
 */
@TableName("tbl_pet_info")
@Data
public class PetInfo {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** 主人id */
	private Integer masterId;
	/** 宠物名字 */
	private String petName;
	/** 宠物种类 */
	private String petType;
	/** 宠物性别 */
	private Integer petSex;
	/** 宠物年龄 */
	private Integer petAge;
	/** 宠物信息类型 0 店养宠物 1 医疗宠物 2 销售宠物 3寄养宠物 */
	private Integer petInfoType;
	/** 照片 */
	private String photo;
	/** 备注 */
	private String remake;
	/** 删除状态 0 未删除 1 已删除 */
	private String delStatus;
	/**  */
	private Integer providerId;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
}
