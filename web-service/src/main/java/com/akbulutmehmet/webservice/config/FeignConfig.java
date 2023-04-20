package com.akbulutmehmet.webservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.akbulutmehmet.webservice"})
public class FeignConfig {
}
