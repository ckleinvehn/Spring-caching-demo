package edu.depaul.cachingbyexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.aws.cache.config.annotation.CacheClusterConfig;
import org.springframework.cloud.aws.cache.config.annotation.EnableElastiCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
@EnableElastiCache({@CacheClusterConfig(name = "fibonacci")})
@Profile("prod")
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config =
            new RedisStandaloneConfiguration(redisHost, redisPort);

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(config);
        connectionFactory.getPoolConfig().setMinIdle(10);
        connectionFactory.getPoolConfig().setMaxIdle(30);

        return connectionFactory;
    }


    @Bean(value = "redisTemplate")
    public RedisTemplate<String, Integer> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setEnableTransactionSupport(false);
        return template;
    }


    @Bean(name = "cacheManager")
    public CacheManager createRedisManager(JedisConnectionFactory jedisConnectionFactory) {
        return RedisCacheManager
            .builder(jedisConnectionFactory)
            .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig())
            .build();
    }
}
