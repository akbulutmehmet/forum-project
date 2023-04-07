package com.akbulutmehmet.authservice.manager;


import com.akbulutmehmet.authservice.dto.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(url = "localhost:8082/api/v1/profile", name = "profileFeignClient", decode404 = true)
public interface IProfileManager {
    @PostMapping(value = "/createUser")
    ResponseEntity<String> createUser(@RequestBody  UserDto userDto);
}