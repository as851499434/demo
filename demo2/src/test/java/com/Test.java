package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.DemoApplication;
import com.example.demo.config.Rabbitmq.Producer;
import com.example.demo.utils.HttpClientUtil;
import com.example.demo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;


/**
 * @Author: liangfan
 * @Date: 2021-12-06 08:58
 * @Description:
 */
@Slf4j
//@SpringBootTest(classes = DemoApplication.class)
public class Test {
    @Resource
    private RedisUtil redisUtil;


    @Resource
    private Producer producer;

    @org.junit.jupiter.api.Test
    public void send() {
        int i = 1;
        while (true) {
            HashMap<String,String> map = new HashMap();
            map.put("message",UUID.randomUUID().toString());
            HttpClientUtil.doPost("http://localhost:7778/rabbitmq-info/sendMessage", map);
            i++;
        }

    }

    @org.junit.jupiter.api.Test
    public void test() throws EmailException {
//        HtmlEmail email = new HtmlEmail();
//        email.setHostName("smtp.163.com");
//        email.setCharset("utf-8");
//        email.addTo("1415128257@qq.com");
//        email.setFrom("liangfan1104@163.com", "YouReallyFather");
//        email.setAuthentication("liangfan1104@163.com", "PJOEFILKETLENMNZ");
//        email.setSubject("来自某玩家的游戏邀请");
//        email.setMsg("今晚要玩APEX吗？");
//        email.send();
    }


}
