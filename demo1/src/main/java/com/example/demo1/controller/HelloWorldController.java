package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liangfan
 * @Date: 2021-11-25 13:59
 * @Description: 跨域测试类
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/helloWorld")
//    @CrossOrigin(origins = "*",maxAge = 3600)
    public String hello() {
        return "hello world";
    }
}
