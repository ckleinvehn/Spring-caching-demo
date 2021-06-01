package edu.depaul.cachingbyexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;


@SpringBootApplication
public class CachingByExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(CachingByExampleApplication.class, args);
	}

	@Configuration
	@EnableCaching
	@Profile("!prod") // for testing purposes locally
	public static class DevCacheConfiguration {
		@Bean
		public CacheManager createSimpleCacheManager() {
			SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

			List<Cache> caches = List.of(
				new ConcurrentMapCache("fibonacci")
			);

			simpleCacheManager.setCaches(caches);
			return simpleCacheManager;
		}
	}
}
