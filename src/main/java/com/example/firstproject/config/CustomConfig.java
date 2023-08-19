package com.example.firstproject.config;

import com.example.firstproject.service.impl.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    @Bean
    public SwimCoach swimCoach() {
        return new SwimCoach();
    }
}
