package com.example.demo2_zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class Demo2ZookeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2ZookeeperApplication.class, args);
	}

}
