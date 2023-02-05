package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostMapping("/greeting")
    public ResponseEntity<?> greet(HttpServletRequest httpServletRequest, @RequestBody Map body, @RequestHeader Map headers) throws JsonProcessingException, NoSuchAlgorithmException, InvalidKeyException {
        String hashBody =
                httpServletRequest.getHeader("digest")
                        .replace("HA-256=", "");
        String s1 = new ObjectMapper().writeValueAsString(body);
        StringBuilder stringBuilder = new StringBuilder(s1);
        stringBuilder.append(httpServletRequest.getHeader("date"));
        String bodyString = stringBuilder.toString();
        System.out.println(headers);
        System.out.println(body);

        String alg = "HmacSHA256";
        String key = "123456789";
        String s = hmacWithJava(alg, bodyString, key);
        System.out.println(s);
        System.out.println(hashBody.equals(s));
        return ResponseEntity.ok("Greeting!");
    }

    @GetMapping("/names/{name}")
    public ResponseEntity<?> greetWithName(@PathVariable("name") String name, @RequestHeader Map headers) {
        System.out.println(headers);
        return ResponseEntity.ok(Map.of("key", "my_key"));
    }


    public static String hmacWithJava(String algorithm, String data, String key)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(secretKeySpec);
        return bytesToHex(mac.doFinal(data.getBytes()));
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte h : hash) {
            String hex = Integer.toHexString(0xff & h);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }


}
