package com.example.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Repository {
    public String findUserById(String id) {
        try {
            Thread.sleep(3000);
            return id.toUpperCase();
        } catch (Exception exception) {

        }
        log.info("Return the user result from repository");
        return id.toUpperCase();
    }
}