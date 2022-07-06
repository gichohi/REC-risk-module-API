package com.digitech.rec.risk.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components())
        .info(new Info()
            .title("REC API")
            .description("This is a REST API expenses service using springdoc-openapi and OpenAPI 3.")
            .contact(new Contact().email("@gichohi"))
            .license(new License().name("MIT"))
            .version("1.0")
        );
  }
}
