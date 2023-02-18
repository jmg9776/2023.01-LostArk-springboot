package com.example.lostark;

import com.example.lostark.thirdParty.lostArk.api.LostArkDataConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
public class LostArkApplication {
    public static void main(String[] args) {
        SpringApplication.run(LostArkApplication.class, args);
    }

}
