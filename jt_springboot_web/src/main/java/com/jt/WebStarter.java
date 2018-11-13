package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:springmvc-config.xml")
public class WebStarter {
	public static void main(String[] args) {
		SpringApplication.run(WebStarter.class, args);
	}
}
