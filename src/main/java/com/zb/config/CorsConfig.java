package com.zb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//处理跨域问题
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1. 创建CORS配置对象
        CorsConfiguration config = new CorsConfiguration();
        
        // 允许的源（生产环境建议指定具体域名，而非*）
        config.addAllowedOriginPattern("*");
        
        // 允许携带凭证（cookie等）
        config.setAllowCredentials(true);
        
        // 允许的HTTP方法
        config.addAllowedMethod("*");
        
        // 允许的请求头
        config.addAllowedHeader("*");
        
        // 暴露的响应头（前端可以获取的额外响应头）
        config.addExposedHeader("token");
        
        // 预检请求的缓存时间（秒）
        config.setMaxAge(3600L);
        
        // 2. 创建URL匹配源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路径应用CORS配置
        source.registerCorsConfiguration("/**", config);
        
        // 3. 创建并返回CORS过滤器
        return new CorsFilter(source);
    }
}
