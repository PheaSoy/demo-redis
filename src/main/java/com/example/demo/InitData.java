package com.example.demo;

import com.example.demo.entity.ContentConfig;
import com.example.demo.entity.ServiceContent;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitData {

//    private final ServiceContentRepo serviceContentRepo;
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//            ContentConfig contentConfig = ContentConfig.builder()
//                    .contentKh("khmer")
//                    .content("english")
//                    .title("hello test")
//                    .build();
//            ServiceContent serviceContent = ServiceContent.builder()
//                    .content(contentConfig)
//                    .serviceId("test_service")
//                    .build();
//            serviceContentRepo.save(serviceContent);
//        };
//    }
}
