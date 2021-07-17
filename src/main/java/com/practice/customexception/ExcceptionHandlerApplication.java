package com.practice.customexception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = "com.practice.customexception")
public class ExcceptionHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcceptionHandlerApplication.class, args);
	}
}