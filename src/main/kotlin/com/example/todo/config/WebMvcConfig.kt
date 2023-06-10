package com.example.todo.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
            .allowedOrigins(
                "http://127.0.0.1:5500",
            )
            .allowedHeaders("*")
            .allowCredentials(true)
            .allowedHeaders("Authorization", "Content-Type", "Refresh-Token")
            .exposedHeaders(HttpHeaders.CONTENT_DISPOSITION)
    }
}