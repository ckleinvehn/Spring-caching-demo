package edu.depaul.cachingbyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingByExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(CachingByExampleApplication.class, args);
	}
}
