package com.example.demo;

import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("cacheConfigurationSpecs")
@ConfigurationProperties(prefix = "caching")
@Data
public class CacheConfiguration {

  private Map<String, CacheSpec> specs;

  @Data
  public static class CacheSpec {

    private Integer expired;
    private Integer max = 50;
  }


}
