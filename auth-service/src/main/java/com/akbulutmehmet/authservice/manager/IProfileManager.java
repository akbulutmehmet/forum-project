package com.akbulutmehmet.authservice.manager;


import com.akbulutmehmet.authservice.dto.request.UserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${profile.service.url}", name = "profileFeignClient", decode404 = true)
public interface IProfileManager {
    @PostMapping(value = "/createProfile")
    ResponseEntity<String> createProfile(@RequestBody UserRequestDto userRequestDto);
}