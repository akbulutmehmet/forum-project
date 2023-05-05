package com.akbulutmehmet.authservice.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = {"com.akbulutmehmet.authservice"})
@EnableEurekaClient
public class CloudConfig {
}