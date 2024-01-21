package com.example.amadeus.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("amadeus-api")
                .packagesToScan("com.example.amadeus.controller") // Controller'ların bulunduğu paket
                .build();
    }
}