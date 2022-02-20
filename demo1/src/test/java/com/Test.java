package com;

import com.example.demo1.config.Rabbitmq.Producer;
import com.example.demo1.utils.HttpClientUtil;
import com.example.demo1.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;

import javax.annotation.Resource;
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
        int i = 100;
        while (i-- > 0) {
            HashMap<String,String> map = new HashMap();
            map.put("message",UUID.randomUUID().toString());
            HttpClientUtil.doPost("http://localhost:8001/rabbitmq-info/sendMessage", map);
            i--;
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
