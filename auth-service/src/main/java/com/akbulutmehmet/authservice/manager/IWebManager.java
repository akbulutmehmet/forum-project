package com.akbulutmehmet.authservice.manager;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(url = "localhost:8083/api/v1/web", name = "webFeignClient", decode404 = true)
public interface IWebManager {

}
