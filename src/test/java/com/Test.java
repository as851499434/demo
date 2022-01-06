package com;

import com.example.demo.DemoApplication;
import com.example.demo.config.Rabbitmq.Producer;
import com.example.demo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;


/**
 * @Author: liangfan
 * @Date: 2021-12-06 08:58
 * @Description:
 */
@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class Test {
    @Resource
    private RedisUtil redisUtil;


    @Resource
    private Producer producer;

    @org.junit.jupiter.api.Test
    public void send() {
        for (int i = 0; i < 10; i++) {
            producer.send("消息：" + i);
        }



    }

    @org.junit.jupiter.api.Test
    public void test() throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.163.com");
        email.setCharset("utf-8");
        email.addTo("773572103@qq.com");
        email.setFrom("liangfan1104@163.com", "liangfan");
        email.setAuthentication("liangfan1104@163.com", "PJOEFILKETLENMNZ");
        email.setSubject("性感荷官，在线发牌");
        email.setMsg("这是测试内容，顺便说一句黄潇旭吃屎");
        email.send();
    }


}
