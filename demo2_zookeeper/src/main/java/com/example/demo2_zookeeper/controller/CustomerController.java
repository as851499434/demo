package com.example.demo2_zookeeper.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.apache.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liangfan
 * @since 2022-01-13
 */
@RestController
@Slf4j
public class CustomerController {

    public static final String INVOKE_URL = "http://demo1-4";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo()
    {
        log.info("信息");
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        log.info("信息{}", result);
        return result;
    }
}
