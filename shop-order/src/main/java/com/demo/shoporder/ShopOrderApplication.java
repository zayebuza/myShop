package com.demo.shoporder;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class ShopOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopOrderApplication.class, args);
	}
}
