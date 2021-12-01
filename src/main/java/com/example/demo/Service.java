package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Slf4j
@org.springframework.stereotype.Service
public class Service {

//    @Cacheable(value = "users", key = "#id")
    public String findUserById(String id) {
        String val = new Repository().findUserById(id);
        return val;
    }

//    @CacheEvict(value = "users", key = "#id")
    public void updateUser(String id) {
    }

}
