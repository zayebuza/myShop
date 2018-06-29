package com.demo.shoporder;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ShopOrderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ShopOrderApplication.class, args);
		new SpringApplicationBuilder(ShopOrderApplication.class)
				.web(false) // 非 Web 应用
				.run(args);

	}
}
