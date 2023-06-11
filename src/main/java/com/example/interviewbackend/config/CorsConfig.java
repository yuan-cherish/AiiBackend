package com.example.interviewbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    // 当前跨域请求最大有效时长，这里默认1天
    private static final long MAX_AGE = 24*60*60;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");    // 设置允许访问的源地址
        corsConfiguration.addAllowedHeader("*");    // 设置允许访问的源请求头
        corsConfiguration.addAllowedMethod("*");    // 设置允许访问的源请求方法
        corsConfiguration.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**", corsConfiguration);    // 对接口配置跨域设置
        return new CorsFilter(source);
    }
}