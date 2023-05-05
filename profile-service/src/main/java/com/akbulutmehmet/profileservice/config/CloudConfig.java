package com.akbulutmehmet.profileservice.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.akbulutmehmet.profileservice"})
@EnableEurekaClient
public class CloudConfig {
}
