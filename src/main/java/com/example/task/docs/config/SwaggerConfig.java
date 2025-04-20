package com.example.task.docs.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API 명세서")
                        .version("1.0.0")
                        .description("바로인턴 11기 JWT 과제 \n\n https://github.com/jiyeon0926/jwt-task"));
    }

    @Bean
    public GroupedOpenApi docsApi() {
        return GroupedOpenApi.builder()
                .group("docs")
                .packagesToScan("com.example.task.docs")
                .build();
    }
}
