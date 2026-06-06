package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwagggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Processing System API")
                        .version("1.0")
                        .description("REST API for Order Processing System")
                        .contact(new Contact()
                                .name("Samir Shaikh")
                                .email("samir@example.com"))
                        .license(new License()
                                .name("Apache 2.0")));
    }

}
