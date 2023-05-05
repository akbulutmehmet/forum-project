package com.akbulutmehmet.authservice.manager;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "web-service", path = "api/v1/")
public interface IWebManager {

}
