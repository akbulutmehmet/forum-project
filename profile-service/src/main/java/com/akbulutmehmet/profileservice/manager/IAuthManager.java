package com.akbulutmehmet.profileservice.manager;

import com.akbulutmehmet.profileservice.dto.request.TokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "auth-service", path = "/api/v1/user")
public interface IAuthManager {
    @PostMapping(value = "/tokenControl")
    Boolean tokenControl (@Valid @RequestBody TokenRequest tokenRequest);
}
