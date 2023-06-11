package com.example.qcadminserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Xman
 * @version 1.0
 * @date 2023/6/11 15:15
 */
@Configuration
public class crosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //springboot 2.4以上的版本更新 如果设置了allowCredentials为true的话那么
                //allowedOrigin就不能为 * 只能被替换为allowedOriginPatterns才能设置星号
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedHeaders(org.springframework.web.cors.CorsConfiguration.ALL)
                .allowedMethods(org.springframework.web.cors.CorsConfiguration.ALL)
                .maxAge(3600);
    }
}
