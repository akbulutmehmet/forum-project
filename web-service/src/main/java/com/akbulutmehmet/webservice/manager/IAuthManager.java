package com.akbulutmehmet.webservice.manager;


import com.akbulutmehmet.webservice.dto.request.TokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(url = "localhost:8081/api/v1/user", name = "authFeignClient", decode404 = true)
public interface IAuthManager {
    @PostMapping(value = "/tokenControl")
    Boolean tokenControl (@Valid @RequestBody TokenRequest tokenRequest);
}
