package com.example.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper,com.example.*.mapper")
public class DemoApplication {
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*当端口启动后，直接跳转界面*/
	@EventListener({ApplicationReadyEvent.class})
	void applicationReadyEvent() {
		System.out.println("应用已经准备就绪 ... 启动浏览器");
		System.out.println("端口号是:" + port);
		String url = "http://localhost:"+port+"/index";
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
