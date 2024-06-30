package com.example.springapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configure CORS mappings for your application
        registry.addMapping("/**")  // Apply CORS settings to all paths
                .allowedOrigins("http://localhost:5173")  // Allow requests from the Vite development server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                .allowedHeaders("Content-Type", "Authorization")  // Allowed request headers
                .allowCredentials(true)  // Allow cookies, authorization headers, or TLS client certificates
                .maxAge(3600);  // Cache preflight requests for 1 hour (3600 seconds)
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")  // Frontend URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed methods
                        .allowedHeaders("*")  // Allowed headers
                        .allowCredentials(true)  // Allow credentials
                        .maxAge(3600);  // Cache duration for preflight responses
            }
        };
    }
}
