package com.akbulutmehmet.webservice.config;

import com.akbulutmehmet.webservice.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class AppConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;

    public AppConfig(@Lazy  AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }
}
