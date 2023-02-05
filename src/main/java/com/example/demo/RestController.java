package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
public class RestController {

    List<User> users = new ArrayList<>();

    @GetMapping("/list")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/check/{status}")
    public ResponseEntity<?> check(@PathVariable("status") String status) {
        if (status.equals("ok"))
            return ResponseEntity.ok(users);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(users);
    }


    @PostMapping("/create")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }

    @PostMapping("/delete")
    public List<User> deteleUser(@RequestBody User user) {
        users.remove(user);
        return users;
    }
}
