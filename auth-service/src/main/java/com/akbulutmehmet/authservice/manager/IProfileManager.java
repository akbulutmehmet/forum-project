package com.akbulutmehmet.authservice.manager;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "localhost:8082/profile", name = "profileFeignClient", decode404 = true)
public interface IProfileManager {

}