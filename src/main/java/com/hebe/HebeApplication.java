package com.hebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HebeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HebeApplication.class, args);
	}
}
