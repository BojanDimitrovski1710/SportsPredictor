package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.*")
@ComponentScan(basePackages = "com.example.*")
public class SportsPredictApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsPredictApplication.class, args);
	}

}
