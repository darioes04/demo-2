package com.example.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
<<<<<<< HEAD
                registry.addMapping("/api/**") // o /** si es todo tu backend
                        .allowedOrigins("books-app-des.netlify.app") // frontend Angular
=======
                registry.addMapping("/api/**")
                        .allowedOrigins(
                            "http://localhost:4200",
                            "https://books-app-des.netlify.app"
                        )
>>>>>>> 2f844017100d347f1cc176406f2b9d684e5c5413
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
