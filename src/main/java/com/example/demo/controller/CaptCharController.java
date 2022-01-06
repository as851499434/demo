package com.example.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.codec.Base64;
import com.example.demo.mapper.PetInfoMapper;
import com.example.demo.utils.IpUtils;
import com.example.demo.utils.RedisUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @Author: liangfan
 * @Date: 2021-12-07 09:49
 * @Description:
 */
@RestController
@RequestMapping("/captchar")
@Slf4j
public class CaptCharController {
    @Resource
    private RedisUtil redisUtil;

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Value("${captChar.type}")
    private String captCharType;



    /**
     * 验证码生成
     */
    @GetMapping(value = "/captchaImage")
    public String getKaptchaImage(HttpServletRequest request, HttpServletResponse response)  {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(111, 36,4,2);
        String code = captcha.getCode();
        log.info("正确验证码是:{}", code);
        String key = IpUtils.getIpAddr(request);

        redisUtil.set(key, code, 60);
        String value = redisUtil.get(key).toString();
        HttpSession session = request.getSession();
        log.info("session ID : {}",session.getId());
        log.info("key是:{}", key);
        log.info("得到的验证码是:{}", value);
        return captcha.getImageBase64();
    }

    @PostMapping(value = "/check")
    public Boolean checkKaptchaValue(String key, String userValue) {
        if (redisUtil.hasKey(key)) {
            if (userValue.equals(redisUtil.get(key).toString())) {
                return true;
            }
        }
        return false;
    }


    @GetMapping(value = "/captchaImage2")
    public void getKaptchaImage2(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream out = null;
        try {
            HttpSession session = request.getSession();
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");
            String type = captCharType;
            String capStr = null;
            String code = null;
            BufferedImage bi = null;
            if ("math".equals(type)) {
                String capText = captchaProducerMath.createText();
                capStr = capText.substring(0, capText.lastIndexOf("@"));
                code = capText.substring(capText.lastIndexOf("@") + 1);
                bi = captchaProducerMath.createImage(capStr);
            } else if ("char".equals(type)) {
                capStr = code = captchaProducer.createText();
                bi = captchaProducer.createImage(capStr);
            }
            log.info("正确验证码是:{}", code);
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, code);

            //sessin
            Enumeration<String> attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String name = attributeNames.nextElement();
                Object value = request.getSession().getAttribute(name);
                log.info("name:{} value:{}",name,value);
            }
            log.info("session ID : {}",session.getId());
            redisUtil.set("liangfan", code, 60);
            String liangfan = redisUtil.get("liangfan").toString();
            log.info("得到的验证码是:{}", liangfan);
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 合法E-mail地址：
     * 1. 必须包含一个并且只有一个符号“@”
     * 2. 第一个字符不得是“@”或者“.”
     * 3. 不允许出现“@.”或者.@
     * 4. 结尾不得是字符“@”或者“.”
     * 5. 允许“@”前的字符中出现“＋”
     * 6. 不允许“＋”在最前面，或者“＋@”
     */
    private boolean validEmail(String email) {
        String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return Pattern.compile(regex).matcher(email).find();
    }



}



