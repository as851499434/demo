package com.example.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liangfan
 * @Date: 2022-01-25 14:42
 * @Description:
 *
 * NoArgsConstructor 生成无参构造函数
 * AllArgsConstructor 生成全参数构造函数
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
