package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.Map;

import static org.springframework.data.redis.cache.RedisCacheConfiguration.*;

@Configuration
@ConditionalOnProperty(value = "hatthabank.cache.type", havingValue = "redis")
public class CacheRedisConfig {

    @Autowired
    @Qualifier("cacheConfigurationSpecs")
    private CacheConfiguration cacheConfiguration;

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        RedisCacheManagerBuilderCustomizer cacheManagerBuilderCustomizer =
                (builder) -> {
                    Map<String, CacheConfiguration.CacheSpec> specs = cacheConfiguration.getSpecs();
                    if (specs != null) {
                            specs.entrySet()
                                .stream()
                                .forEach(spec -> builder
                                        .withCacheConfiguration(spec.getKey(),
                                                defaultCacheConfig().entryTtl(Duration.ofSeconds(spec.getValue().getExpired())))
                                );
                    }
                    ;
                };
        return cacheManagerBuilderCustomizer;


    }

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

}


