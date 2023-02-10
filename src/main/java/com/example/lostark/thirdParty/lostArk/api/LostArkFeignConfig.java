package com.example.lostark.thirdParty.lostArk.api;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class LostArkFeignConfig {
    LostArkDataConfiguration lostArkDataConfiguration = new LostArkDataConfiguration();
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
          requestTemplate.header("Authorization", "Bearer " + lostArkDataConfiguration.getApiKey());
          requestTemplate.header("Accept", "application/json");
        };
    }
}
